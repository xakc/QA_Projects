package com.n3.WD.support;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Window {
	
	private static Window window;
	private static WebDriver wdDriver;
	private WebElement element;
	
	private Window(WebDriver driver){
		wdDriver = driver;
	}
	
	public static Window getInstance(WebDriver driver){
		if(window == null || wdDriver.hashCode() != driver.hashCode())
			window = new Window(driver);
		return window;
	}
	
	private List<String> getWindowIds(){
		ArrayList<String> windowIds = new ArrayList<>(wdDriver.getWindowHandles());
		return Collections.unmodifiableList(windowIds);
	}
	
	public void switchToWindow(int index){
		
		ArrayList<String> windowIds = new ArrayList<>(getWindowIds());
		
		if(index < 0 || index > windowIds.size())
			throw new IllegalArgumentException("Index is not valid " + index);
		
		wdDriver.switchTo().window(windowIds.get(index));
		
	}
	
	public void switchToParent(){
		ArrayList<String> windowIds = new ArrayList<>(getWindowIds());
		wdDriver.switchTo().window(windowIds.get(0));
	}
	
	public void switchToParentWithClose(){
		ArrayList<String> windowIds = new ArrayList<>(getWindowIds());
		
		for(int i = 1; i < windowIds.size(); i++){
			wdDriver.switchTo().window(windowIds.get(i));
			wdDriver.close();
		}
		
		switchToParent();
	}

}
