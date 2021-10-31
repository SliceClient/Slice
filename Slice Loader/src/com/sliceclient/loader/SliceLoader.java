package com.sliceclient.loader;

import com.sliceclient.loader.security.Check;
import com.sliceclient.loader.security.CheckManager;
import com.sliceclient.loader.security.authchecks.AuthHWID;
import com.sliceclient.loader.security.authchecks.AuthWebhook;
import com.sliceclient.loader.ui.UILaunch;
import com.sliceclient.loader.ui.UINotWindows;
import com.sliceclient.loader.util.OSUtil;

public class SliceLoader {
	//public static final boolean isRunningOnMac = OSUtil.getOSType() == OSUtil.EnumOS.OSX;
	public static final boolean runningOnWindows = OSUtil.getOSType() == OSUtil.EnumOS.WINDOWS;
	public static void main(String[] args) {
		runAuth();
		/*if(!runningOnWindows == true) {
			UINotWindows.openUI();
		}*/
		UILaunch.openUI();
	}
	public static void runAuth() {
		AuthWebhook.auth();
		AuthHWID.auth();
	}
}
