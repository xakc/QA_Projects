package com.n3.POM.QualityHouse;

import com.n3.WD.support.TextBox;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ContactUsClass extends PageBase {

    public String pageTitle = "Contact Us | Quality House Ltd.";
    private WebDriver driver;
    private TextBox textBox;


    public ContactUsClass(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    //WebElements
    //1.ContactUs form UI map
    //1.1. Form Header
    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Get in')]")
    public WebElement contactUs_Form_header;

    // 1.2. Requester info
    @FindBy(how = How.XPATH, using = "//input[@id='name']")
    public WebElement contactUs_Form_requester_NameInfo;
    @FindBy(how = How.XPATH, using = "//input[@id='email']")
    public WebElement contactUs_Form_requester_EmailInfo;

    //1.3.Request message Subject and text
    @FindBy(how = How.XPATH, using = "//input[@id='subject']")
    public WebElement contactUs_Form_Subject;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/textarea[1]")
    public WebElement contactUs_Form_Message;

    //1.4.
    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    public WebElement contactUs_Form_GDPR_checkbox;

    //1.5.
    @FindBy(how = How.XPATH, using = "  //input[@type='submit']")
    public WebElement contactUs_Form_SendMsg_button;

    //Page methods
    //Fields methods
    public void enter_name(String RequesterNames) {
        getWait().until(ExpectedConditions.elementToBeClickable(contactUs_Form_requester_NameInfo));

        contactUs_Form_requester_NameInfo.isDisplayed();
        contactUs_Form_requester_NameInfo.isEnabled();

        contactUs_Form_requester_NameInfo.clear();
        contactUs_Form_requester_NameInfo.sendKeys(RequesterNames);
    }

    public void enter_email(String email) {
        getWait().until(ExpectedConditions.elementToBeClickable(contactUs_Form_requester_EmailInfo));
        contactUs_Form_requester_EmailInfo.isDisplayed();

        contactUs_Form_requester_EmailInfo.clear();
        contactUs_Form_requester_EmailInfo.sendKeys(email);
    }

    public void enter_subject(String subject) throws InterruptedException {
        Thread.sleep(4000);
        getWait().until(ExpectedConditions.elementToBeClickable(contactUs_Form_Subject));
        contactUs_Form_Subject.isDisplayed();
        contactUs_Form_Subject.clear();
        contactUs_Form_Subject.sendKeys(subject);
    }

    public void enter_message(String message) throws InterruptedException {
        getWait().until(ExpectedConditions.visibilityOf(contactUs_Form_Message));
        contactUs_Form_Message.sendKeys(Keys.TAB);
        contactUs_Form_Message.clear();
        contactUs_Form_Message.sendKeys(message);
    }


    public void accept_GDPR() throws InterruptedException {
        getWait().until(ExpectedConditions.elementToBeClickable(contactUs_Form_GDPR_checkbox));
        contactUs_Form_GDPR_checkbox.isDisplayed();
        contactUs_Form_GDPR_checkbox.click();
    }

    public void send_message() {
        getWait().until(ExpectedConditions.elementToBeClickable(contactUs_Form_SendMsg_button));
        contactUs_Form_SendMsg_button.isDisplayed();
        contactUs_Form_SendMsg_button.click();
    }

    public void checkContactUsPageURL() {
        Assert.assertEquals(driver.getTitle(),pageTitle);
    }

    public void checkContactUsHeaderPage() {
        getWait().until(ExpectedConditions.visibilityOf(contactUs_Form_header));
    }
}
