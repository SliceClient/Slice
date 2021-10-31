package com.sliceclient.loader.security.authchecks;

import com.sliceclient.loader.security.Check;
import com.sliceclient.loader.util.HWIDUtil;
import com.sliceclient.loader.util.WebhookUtil;

public class AuthWebhook extends Check {
	public static void auth() {
    try {
    	sendSecurityMessage("Slice Security > A User Has Loaded Slice Loader || HWID: " + HWIDUtil.getHWID() + "||");
        } catch(Exception e) {
        e.printStackTrace();
        }
	}
}
