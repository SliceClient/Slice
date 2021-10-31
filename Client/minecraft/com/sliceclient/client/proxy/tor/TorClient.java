package com.sliceclient.client.proxy.tor;

/*import com.msopentech.thali.java.toronionproxy.JavaOnionProxyContext;
import com.msopentech.thali.java.toronionproxy.JavaOnionProxyManager;
import com.msopentech.thali.java.toronionproxy.OnionProxyManager;*/

import java.io.File;
import java.io.IOException;

public class TorClient implements Runnable {

    /*public static OnionProxyManager onionProxyManager;*/

    @Override
    public void run() {
        /*String fileStorageLocation = "memeware-tor-proxy";
        onionProxyManager = new JavaOnionProxyManager(
                new JavaOnionProxyContext(new File(fileStorageLocation)));

        final int totalSecondsPerTorStartup = 4 * 60;
        final int totalTriesPerTorStartup = 5;
        try {
            onionProxyManager.startWithRepeat(totalSecondsPerTorStartup, totalTriesPerTorStartup);
            onionProxyManager.SetupSocks5Proxy(57441);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }*/
    }

}
