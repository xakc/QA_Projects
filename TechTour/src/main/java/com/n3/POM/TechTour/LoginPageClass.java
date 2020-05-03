package com.n3.POM.TechTour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageClass extends PageBase {
	
	private WebDriver driver;
	
	public LoginPageClass(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}



}
