package com.n3.POM.QualityHouse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageClass extends PageBase {
	
	private WebDriver driver;
	@FindBy (how = How.CSS,using = "div.body:nth-child(3) div.header-body div.header-container.container div.header-row div.header-column:nth-child(2) div.header-row:nth-child(2) div.header-nav.clearfix div.header-nav-main.header-nav-main-effect-1.header-nav-main-sub-effect-1.collapse nav:nth-child(1) ul.nav.nav-pills li.dropdown:nth-child(6) > a.dropdown-toggle")
	public WebElement nav_contactUs;
	@FindBy(how = How.XPATH,using = "//input[@id='email']")
	public WebElement REG_email_FIELD;

	public HomePageClass(WebDriver driver){
		super(driver);
		this.driver = driver;
	}

	public PageBase navigate_to_ContactUs_Page() {
		nav_contactUs.click();
		ContactUsClass contactUs = new ContactUsClass(driver);
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(contactUs.navBar_contactUs));
		return contactUs;

	}

}
