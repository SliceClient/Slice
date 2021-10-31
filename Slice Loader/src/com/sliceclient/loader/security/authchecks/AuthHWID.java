package com.sliceclient.loader.security.authchecks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import com.sliceclient.loader.security.Check;
import com.sliceclient.loader.ui.UINotAuthed;
import com.sliceclient.loader.util.HWIDUtil;

public class AuthHWID extends Check {
	public static void auth() {
		getAuthHWIDs();
		boolean authed = isUser(getHWID());
		if(authed == true) {
			System.out.println("Slice Security > Authentication Complete!");
		} else {
			System.out.println("Slice Security > Authentication Failed!");
			System.out.println("Slice Security > Error Code 0x1289QCA");
			notAuthed();
			}
	}
    public static ArrayList<String> AuthedUsers = new ArrayList<>();


    public static void getAuthHWIDs() {
        try
        {
        	
        	//URL list = new URL("https://raw.githubusercontent.com/SliceClient/AuthData/main/AuthTest.txt");	
            URL list = new URL("https://raw.githubusercontent.com/SliceClient/AuthData/main/HWIDs.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(list.openStream()));
            String userLine;
            while ((userLine = bufferedReader.readLine()) != null)
            {
                AuthedUsers.add(userLine);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static boolean isUser(String hwid) {
        return AuthedUsers.contains(hwid);
    }
}
