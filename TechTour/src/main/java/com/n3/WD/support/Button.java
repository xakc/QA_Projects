package com.n3.WD.support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button {
	
	private static Button button;
	private static WebDriver wdDriver;
	
	private Button(WebDriver driver){
		wdDriver = driver;
	}
	
	public static Button getInstance(WebDriver driver){
		if(button == null || wdDriver.hashCode() != driver.hashCode())
			button = new Button(driver);
		return button;
	}
	
	public void click(By locator){
		wdDriver.findElement(locator).click();
	}

}
