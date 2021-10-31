package com.sliceclient.loader.util;

public class OSUtil {
	   public static OSUtil.EnumOS getOSType()
	    {
	        String var0 = System.getProperty("os.name").toLowerCase();
	        return var0.contains("win") ? OSUtil.EnumOS.WINDOWS : (var0.contains("mac") ? OSUtil.EnumOS.OSX : (var0.contains("solaris") ? OSUtil.EnumOS.SOLARIS : (var0.contains("sunos") ? OSUtil.EnumOS.SOLARIS : (var0.contains("linux") ? OSUtil.EnumOS.LINUX : (var0.contains("unix") ? OSUtil.EnumOS.LINUX : OSUtil.EnumOS.UNKNOWN)))));
	    }

	    public static enum EnumOS
	    {
	        LINUX("LINUX", 0),
	        SOLARIS("SOLARIS", 1),
	        WINDOWS("WINDOWS", 2),
	        OSX("OSX", 3),
	        UNKNOWN("UNKNOWN", 4);
	    	private static final OSUtil.EnumOS[] $VALUES = new OSUtil.EnumOS[]{LINUX, SOLARIS, WINDOWS, OSX, UNKNOWN};
	    	private EnumOS(String Name, int Value) {}
	    }
}
