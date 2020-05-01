package com.n3.WD.support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBox {
	
	private static TextBox textBox;
	private static WebDriver wdDriver;
	private WebElement element;
	
	private TextBox(WebDriver driver){
		wdDriver = driver;
	}
	
	public static TextBox getInstance(WebDriver driver){
		if(textBox == null || wdDriver.hashCode() != driver.hashCode())
			textBox = new TextBox(driver);
		return textBox;
	}
	
	public void setText(By locator,String value){
		element = wdDriver.findElement(locator);
		element.sendKeys(value);
	}
	
	public String getText(By locator){
		element = wdDriver.findElement(locator);
		String value = element.getText();
		return value;
	}
	
	public void clear(By locator){
		element = wdDriver.findElement(locator);
		element.clear();
	}

}
