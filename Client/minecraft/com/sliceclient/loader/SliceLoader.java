package com.sliceclient.loader;

import com.sliceclient.client.Client;
import com.sliceclient.loader.check.CheckHWIDAuth;
import com.sliceclient.loader.check.CheckWebhook;

public class SliceLoader {
	//public static SliceLoader Loader;
	public static void load() {
		CheckHWIDAuth.auth();
		CheckWebhook.auth();
		Client.INSTANCE.initialize();
	}
}
