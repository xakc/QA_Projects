package com.n3.POM.TechTour;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageClass extends PageBase {
	
	private WebDriver driver;
	
	public HomePageClass(WebDriver driver){
		super(driver);
		this.driver = driver;

	}

	@FindBy(how = How.XPATH,using = "//a[text()='Login']")
	public WebElement nav_login_btn;

	@FindBy(how = How.XPATH,using = "//*[@id=\"main-menu\"]/div/div[2]/ul/li[7]/a")
	public WebElement navBar_profileMenu;


	public PageBase navigate_to_Login_Page() {
		LoginPageClass loginPage = new LoginPageClass(driver);

		nav_login_btn.click();

		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.login_btn));

		return loginPage;


	}


}
