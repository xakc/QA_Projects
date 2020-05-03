package com.n3.WD.settings.classloader;

import java.net.URL;

public class AbsolutePath {
	
	public static void main(String[] args) {

		
		Class cls = AbsolutePath.class;
		ClassLoader loader = cls.getClassLoader();
		URL url = loader.getResource("./chromedriver.exe");
		System.out.println(url.toString());
		
	}

}
