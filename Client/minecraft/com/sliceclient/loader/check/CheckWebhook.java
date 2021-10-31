package com.sliceclient.loader.check;

import com.sliceclient.loader.util.HWIDUtil;
import com.sliceclient.loader.util.WebhookUtil;

public class CheckWebhook {
	public static void auth() {
    try {
        WebhookUtil.sendMessage("Slice Security > A User Has Loaded Slice Client || HWID: " + HWIDUtil.getHWID() + "||");
        } catch(Exception e) {
        e.printStackTrace();
        }
	}
}
