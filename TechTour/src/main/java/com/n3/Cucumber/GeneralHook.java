package com.n3.Cucumber;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.n3.WD.support.DriverSvS;

import cucumber.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

@SuppressWarnings(value = "deprecation")
public class GeneralHook {
	
	private DriverSvS services;
	private WebDriver driver;
	
	private static CustomExtentReporter customExtentReporter;
	private static boolean isReporterRunning;
	
	public GeneralHook(DriverSvS services) {
		this.services = services;
		this.driver = services.getDriver();
	}
	
	@Before(value="@regression",order = 2)
	public void setupForRegression(){
		System.out.println("This is regression suite");
	}
	
	@Before(value="@smoke")
	public void setupForSmoke(){
		System.out.println("This is smoke suite");
	}
	
	@Before(order = 1)
	public void setup() {
		System.out.println(" This is normal hook");
	}
	
	@Before
	public void beforeScenario(Scenario scenario) {
		if(!isReporterRunning){
			customExtentReporter = new CustomExtentReporter("D:\\CODES\\TechTour\\TestReport.html");
			isReporterRunning = true;
		}
	}
	
	@After
	public void afterScenario(Scenario scenario) throws IOException {
		String screenShotFileName = "C:\\Data\\log\\" + scenario.getName().replaceAll(" ", "") + ".jpeg";
		if(scenario.isFailed()){
			services.getGeneralSupport().takeScreenShot(screenShotFileName);
		}
		customExtentReporter.createTest(scenario, screenShotFileName);
		customExtentReporter.writeToReport();
		if(driver != null){
	    	driver.quit(); // it will close all the window and stop the web driver
	    }
	}
	
	//@After
	public void teardown(Scenario scenario) {
		if(scenario.isFailed()){
			captureScreenShot(scenario);
		}
		if(driver != null){
	    	driver.quit(); // it will close all the window and stop the web driver
	    }
		
	}
	
	private void captureScreenShot(Scenario scenario) {
		int random = (int)(Math.random() * 1000);
		services.getGeneralSupport().takeScrenShot("Screenshot", "src" + random +".png");
		scenario.embed(services.getGeneralSupport().takeScrenShot(), "image/png");
	}

}
