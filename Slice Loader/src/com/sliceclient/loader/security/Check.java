package com.sliceclient.loader.security;

import com.sliceclient.loader.ui.UINotAuthed;
import com.sliceclient.loader.util.HWIDUtil;
import com.sliceclient.loader.util.WebhookUtil;

public class Check {
	public static void sendSecurityMessage(String Message) {
		WebhookUtil.sendMessage(Message);
	}
	public static String getHWID() {
		return HWIDUtil.getHWID();
	}
	public static void log(String log) {
		System.out.println("Slice Security > " + log);
	}
	public static void closeApp() {
		System.exit(0);
	}
	public static void auth() { }
	public static void notAuthed() {
		UINotAuthed.openUI();
	}
}
