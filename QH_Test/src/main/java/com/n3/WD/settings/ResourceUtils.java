package com.n3.WD.settings;

public class ResourceUtils {
	
	// path based the resurce name
	public static String getResourcePath(String resourceName) {
		String path = getBasePath() + resourceName;
		return path;
	}
	
	// Base path
	public static String getBasePath() {
		String path = ResourceUtils.class.getClassLoader().getResource(".").getPath();
		return path;
	}

}
