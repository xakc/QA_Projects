package com.n3.WD.support;

import org.openqa.selenium.WebDriver;

public class Browser {
	
	private static Browser browser;
	private static WebDriver wdDrvier;
	
	private Browser(WebDriver driver){
		wdDrvier = driver;
	}
	
	public static Browser getInstance(WebDriver driver){
		if(browser == null || wdDrvier.hashCode() != driver.hashCode())
			browser = new Browser(driver);
		return browser;
	}
	

	
	
	public void moveForward(){
		wdDrvier.navigate().forward();
	}
	
	public void moveBackword(){
		wdDrvier.navigate().back();
	}
	
	public void refresh(){
		wdDrvier.navigate().refresh();
	}
	
	public void maximize(){
		wdDrvier.manage().window().maximize();
	}

}
