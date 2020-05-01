package com.n3.POM.TechTour;

import com.n3.WD.support.TextBox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPageClass extends PageBase {

    private WebDriver driver;
    private TextBox textBox;
    WebDriverWait wait;

    public RegistrationPageClass(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @FindBy(how = How.XPATH,using = "//input[@id='first-name-field']")
    public WebElement REG_first_name_FIELD;

    @FindBy(how = How.XPATH,using = "//input[@id='last-name-field']")
    public WebElement  REG_last_name_FIELD;

    @FindBy(how = How.XPATH,using = " //input[@id='email-field']")
    public WebElement  REG_email_FIELD;

    @FindBy(how = How.XPATH,using = "//input[@id='phone-field']")
    public WebElement  REG_phone_FIELD;

    @FindBy(how = How.XPATH,using = "//input[@id='address-field']")
    public WebElement  REG_address_FIELD;

    @FindBy(how = How.XPATH,using = "//input[@id='username-field']")
    public WebElement  REG_userName_FIELD;

    @FindBy(how = How.XPATH,using = "//input[@id='password-field']")
    public WebElement  REG_password_FIELD;

    @FindBy(how = How.XPATH,using = "//input[@id='confirm-password-field']")
    public WebElement  REG_confirmPass_FIELD;

    @FindBy(how = How.XPATH,using = " //button[@id='signup-btn']")
    public WebElement  REG_signUp_BTN;


    public void enter_first_name(String firstName) {
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.visibilityOf(REG_first_name_FIELD));
        REG_first_name_FIELD.isDisplayed();

        REG_first_name_FIELD.clear();
        REG_first_name_FIELD.sendKeys(firstName);
    }

    public void enter_last_name(String lastName) {
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.visibilityOf(REG_last_name_FIELD));
        REG_last_name_FIELD.isDisplayed();

        REG_last_name_FIELD.clear();
        REG_last_name_FIELD.sendKeys(lastName);
    }

    public void enter_email(String email) {
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.visibilityOf(REG_email_FIELD));
        REG_email_FIELD.isDisplayed();

        REG_email_FIELD.clear();
        REG_email_FIELD.sendKeys(email);
    }

    public void enter_phone (String phone) {
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.visibilityOf(REG_phone_FIELD));
        REG_phone_FIELD.isDisplayed();

        REG_phone_FIELD.clear();
        REG_phone_FIELD.sendKeys(phone);
    }

    public void enter_address (String address) {
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.visibilityOf(REG_address_FIELD));
        REG_address_FIELD.isDisplayed();

        REG_address_FIELD.clear();
        REG_address_FIELD.sendKeys(address);
    }


    public void enter_userName(String userName) {
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.visibilityOf(REG_userName_FIELD));
        REG_userName_FIELD.isDisplayed();

        REG_userName_FIELD.clear();
        REG_userName_FIELD.sendKeys(userName);
    }


    public void enter_password(String pass) {
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.visibilityOf(REG_password_FIELD));
        REG_password_FIELD.isDisplayed();

        REG_password_FIELD.clear();
        REG_password_FIELD.sendKeys(pass);
    }

    public void confirm_password(String pass) {
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.visibilityOf(REG_confirmPass_FIELD));
        REG_confirmPass_FIELD.isDisplayed();

        REG_confirmPass_FIELD.clear();
        REG_confirmPass_FIELD.sendKeys(pass);
    }

    public void click_on_signUP_button() {
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.visibilityOf(REG_signUp_BTN));
        REG_signUp_BTN.isDisplayed();

        REG_signUp_BTN.click();
    }





}
