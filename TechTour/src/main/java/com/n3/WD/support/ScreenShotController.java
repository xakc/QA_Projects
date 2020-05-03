package com.n3.WD.support;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class ScreenShotController {
	
	private static ScreenShotController screenShotController;
	private static WebDriver wdDriver;
	
	private ScreenShotController(WebDriver driver){
		wdDriver = driver;
	}
	
	public static ScreenShotController getInstance(WebDriver driver){
		if(screenShotController == null || wdDriver.hashCode() != driver.hashCode())
			screenShotController = new ScreenShotController(driver);
		return screenShotController;
	}
	
	public String takeScrenShot(String aDir,String bFileName){

		
		File directory = new File(aDir);
		
		if(!directory.exists())
			directory.mkdirs();
		
		String aPath = directory.getAbsolutePath() + File.separator + bFileName;
		
		return takeScreenShot(aPath);
	}

	public String takeScreenShot(String aPath) {
		File screenshot = ((TakesScreenshot)wdDriver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(aPath));
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
		return aPath;
	}
	
	public byte[] takeScrenShot(){
		byte[] screenshot = ((TakesScreenshot)wdDriver).getScreenshotAs(OutputType.BYTES);
		return screenshot;
	}

}
