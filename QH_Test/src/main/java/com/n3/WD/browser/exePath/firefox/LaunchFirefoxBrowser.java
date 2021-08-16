package com.n3.WD.browser.exePath.firefox;

import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFirefoxBrowser {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","D:\\AUTOMATION\\BROWSERS\\GeckoDriver\\versions\\26\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		System.out.println(driver.toString());
		
	}

}
