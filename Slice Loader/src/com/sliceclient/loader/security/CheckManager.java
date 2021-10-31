package com.sliceclient.loader.security;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sliceclient.loader.SliceLoader;
import com.sliceclient.loader.security.authchecks.AuthHWID;
import com.sliceclient.loader.security.authchecks.AuthWebhook;
import com.sliceclient.loader.security.authchecks.AuthWireshark;

public class CheckManager {
	public static List<Check> checks = new ArrayList<>();
	public static void runAuthChecks() {
		AuthHWID.auth();
		AuthWebhook.auth();
		if(SliceLoader.runningOnWindows == true) {
			AuthWireshark.auth();
		}
		/*for(Check c : getModules()) {
			c.auth();
		}*/
	}
	public static void registerChecks() {
		checks.add(new AuthHWID());
		checks.add(new AuthWebhook());
		checks.add(new AuthWireshark());
	}
	private static List<Check> getModules() {
        return Collections.unmodifiableList(checks);
    }
}
