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

    //WebElements
    //1.Authentication details
    @FindBy(how = How.XPATH,using = "//input[@id='email']")
    public WebElement  REG_email_FIELD;
    @FindBy(how = How.XPATH,using = "//input[@id='password']")
    public WebElement  REG_password_FIELD;

    @FindBy(how = How.XPATH,using = "//span[contains(text(),'Sign up')]")
    public WebElement  REG_signUp_BTN;

    //2.Personal Information Details
    @FindBy(how = How.XPATH,using = "//input[@id='field_firstName']")
    public WebElement REG_first_name_FIELD;
    @FindBy(how = How.XPATH,using = "//input[@id='field_lastName']")
    public WebElement  REG_last_name_FIELD;

    //3.Event registration progress bar
    @FindBy(how = How.XPATH,using = "//a[contains(text(),'Authenticate')]")
    public WebElement  REG_progressBar_Authenticate;
    @FindBy(how = How.XPATH,using = "//a[contains(text(),'Personal Details')]")
    public WebElement  REG_progressBar_PersonalDetails;
    @FindBy(how = How.XPATH,using = "//a[contains(text(),'Organization')]")
    public WebElement  REG_progressBar_Organization;
    @FindBy(how = How.XPATH,using = "//a[contains(text(),'Completion')]")
    public WebElement  REG_progressBar_Completion;


   //Page methods
    //Fields methods
    public void enter_email(String email) {
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.visibilityOf(REG_email_FIELD));
        REG_email_FIELD.isDisplayed();

        REG_email_FIELD.clear();
        REG_email_FIELD.sendKeys(email);
    }

    public void enter_password(String pass) {
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.visibilityOf(REG_password_FIELD));
        REG_password_FIELD.isDisplayed();

        REG_password_FIELD.clear();
        REG_password_FIELD.sendKeys(pass);
    }

    public void click_on_signUP_button() {
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.visibilityOf(REG_signUp_BTN));
        REG_signUp_BTN.isDisplayed();

        REG_signUp_BTN.click();
    }


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

    //ng-scope current











}
