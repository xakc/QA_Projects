package com.n3.WD.browser.exePath.chrome;

import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChromeBrowser {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\AUTOMATION\\BROWSERS\\chrome\\v83\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(); // web driver framework will launch the browser
		System.out.println(driver.toString());
	}

}
