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

	@FindBy(how = How.XPATH,using = "//a[text()='Login']")
	public WebElement nav_login_btn;

	@FindBy(how = How.XPATH,using = "//input[@id='username-field']")
	public WebElement user_name_field;


	@FindBy(how = How.XPATH,using = "//input[@id='password-field']")
	public WebElement password_field;


	@FindBy(how = How.XPATH,using = "//button[@type='submit']")
	public WebElement login_btn;

	private WebDriver driver;



	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}







	//Support methods

	public void enterTextInInputFieldThourghJavaScript(String cssLocator, String value) {
		JavascriptExecutor driverJs = (JavascriptExecutor) this.driver;
		driverJs.executeScript("document.querySelector('"+cssLocator+"').value='"+value+"';");
	}


	public void enterUser(String user) throws InterruptedException {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOf(user_name_field));

		user_name_field.clear();
		user_name_field.sendKeys(user);

		String text_in_field = user_name_field.getAttribute("value");
		System.out.println(text_in_field);

		Thread.sleep(1555);
	}

	public void logIN(String user, String pass) throws InterruptedException {
		driver.get("http://localhost:8080/login");
		Thread.sleep(2000);
		enterUser(user);
		enterPassword(pass);
		click_on_login_submit_button();
	}

	public void enterPassword(String pass) throws InterruptedException {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOf(password_field));

		password_field.clear();
		password_field.sendKeys(pass);

		String text_in_field = password_field.getAttribute("value");
		System.out.println(text_in_field);
		Thread.sleep(1555);
	}

	public void click_on_login_submit_button() throws InterruptedException {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOf(login_btn));

		login_btn.click();

		Thread.sleep(1500);
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
