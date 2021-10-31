package com.sliceclient.loader.util;

import java.io.File;

public class FileUtil {
    public static File getMinecraftFolder() {
        String userHome = System.getProperty("user.home", ".");
        switch (OSUtil.getOSType()) {

            case LINUX:
                return new File(userHome, ".minecraft/");

            case WINDOWS:
                String applicationData = System.getenv("APPDATA");
                return new File(applicationData != null ? applicationData : userHome, ".minecraft/");

            case OSX:
                return new File(userHome, "Library/Application Support/minecraft");

            default:
                return new File(userHome, "minecraft/");
        }
    }
}
