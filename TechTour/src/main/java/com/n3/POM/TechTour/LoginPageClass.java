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

	@FindBy(how = How.XPATH,using = "//input[@id='username-field']")
	public WebElement user_name_field;


	@FindBy(how = How.XPATH,using = "//input[@id='password-field']")
	public WebElement password_field;


	@FindBy(how = How.XPATH,using = "//button[@type='submit']")
	public WebElement login_btn;


	public void enterUser(String user) throws InterruptedException {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='username-field']")));

		user_name_field.clear();
		user_name_field.sendKeys(user);

		String text_in_field = user_name_field.getAttribute("value");
		System.out.println(text_in_field);

		Thread.sleep(1555);
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

	public void click_on_submit_button() throws InterruptedException {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOf(login_btn));

 		login_btn.click();

		Thread.sleep(1500);
	}


	public void enter_valid_invalid_user(String user) throws InterruptedException {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOf(user_name_field));

		user_name_field.clear();
		user_name_field.sendKeys(user);

		String text_in_field = user_name_field.getAttribute("value");
		System.out.println(text_in_field);

		Thread.sleep(1555);
	}

	public void enter_valid_invalid_password(String pass) throws InterruptedException {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOf(password_field));

		password_field.clear();
		password_field.sendKeys(pass);

		String text_in_field = password_field.getAttribute("value");
		System.out.println(text_in_field);
		Thread.sleep(1555);
	}

}
