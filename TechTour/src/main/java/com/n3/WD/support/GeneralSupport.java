package com.n3.WD.support;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class GeneralSupport {
	
	private static GeneralSupport generalSupport;
	private static WebDriver wdDriver;
	
	private GeneralSupport(WebDriver driver){
		wdDriver = driver;
	}
	
	public static GeneralSupport getInstance(WebDriver driver){
		if(generalSupport == null || wdDriver.hashCode() != driver.hashCode())
			generalSupport = new GeneralSupport(driver);
		return generalSupport;
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
