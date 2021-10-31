package com.sliceclient.loader.security.authchecks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sliceclient.loader.security.Check;
import com.sliceclient.loader.util.HWIDUtil;
import com.sliceclient.loader.util.WebhookUtil;

public class AuthWireshark extends Check {
	public static void auth() {
		try {
			if(wiresharkRunning() == true) {
				closeApp();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			sendSecurityMessage("Slice Security > Could Not Check For Wireshark! Are They Running MacOS / Linux? || HWID: " + HWIDUtil.getHWID() + "||");
			System.out.println("Slice Security > Unable To Check For Wireshark");
			e.printStackTrace();
		}
	}
	public static boolean wiresharkRunning() throws IOException
    {
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("tasklist.exe");

        Process process = pb.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String tasks;
        while ((tasks = br.readLine()) != null)
        {
            if (tasks.toLowerCase().contains("wireshark"))
            {
                return true;
            }
        }

        return false;
    }
}
