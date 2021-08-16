package com.n3.WD.support;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alert {
	
	private static Alert alert;
	private static WebDriver wdDrvier;
	
	private Alert(WebDriver driver){
		wdDrvier = driver;
	}
	
	public static Alert getInstance(WebDriver driver){
		if(alert == null || wdDrvier.hashCode() != driver.hashCode())
			alert = new Alert(driver);
		return alert;
	}
	
	
	private WebDriverWait getWait(){
		WebDriverWait wait = new WebDriverWait(wdDrvier, 60);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoAlertPresentException.class);
		return wait;
	}
	
	public void acceptAlert(){
		org.openqa.selenium.Alert alert = waitForAlert();
		alert.accept();
	}
	
	public void dismissAlert(){
		org.openqa.selenium.Alert alert = waitForAlert();
		alert.dismiss();
	}
	
	public void setAlertTest(String args){
		org.openqa.selenium.Alert alert = waitForAlert();
		alert.sendKeys(args);
		alert.accept();
	}

	private org.openqa.selenium.Alert waitForAlert() {
		WebDriverWait wait = getWait();
		org.openqa.selenium.Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		return alert;
	}
	
	public String getAlertText(){
		org.openqa.selenium.Alert alert = waitForAlert();
		return alert.getText();
	}

}
