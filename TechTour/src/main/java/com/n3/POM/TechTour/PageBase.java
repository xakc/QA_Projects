package com.n3.POM.TechTour;

import java.util.concurrent.TimeUnit;

import com.n3.POM.TechTour.factory.CustomFactory;
import com.n3.POM.TechTour.factory.PageName;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageBase {

	private WebDriver driver;

	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public WebDriverWait getWait(){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait;
	}
	
	

	
	public PageBase navigateTo(PageName name, WebDriver driver, WebElement element){
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOf(element));
		return CustomFactory.getInstance(name, driver);
	}

}
