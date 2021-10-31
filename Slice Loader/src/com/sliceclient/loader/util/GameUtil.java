package com.sliceclient.loader.util;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Logger;

public class GameUtil {
	private String[] launchArgs;
	private final File minecraftFolder = FileUtil.getMinecraftFolder();
    private final File sliceFolder = new File(this.minecraftFolder.getAbsolutePath() + "/Slice");
    public static GameUtil util;
    
    
	public void launchGame() {
		util = this;
        File clientJar = new File(this.sliceFolder.getAbsolutePath() + "/Slice.jar");

        if (clientJar.exists()) {
        	System.out.println("Slice Loader > Classloading client jar, this may take some time depending on your systems speed.");

            try {
                URLClassLoader urlClassLoader = new URLClassLoader(
                        new URL[]{clientJar.toURI().toURL()},
                        this.getClass().getClassLoader()
                );

                Class<?> startClass = Class.forName(
                        "net.minecraft.client.main.Main",
                        true,
                        urlClassLoader
                );

                Method startMethod = startClass.getMethod("main", String[].class);

                System.out.println("Slice Loader > Hooked " + startClass.getName() + " - " + startClass.getName());
                startMethod.invoke(null, (Object) this.launchArgs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Slice Loader > Jar Not Found!");
        }
    }
}
