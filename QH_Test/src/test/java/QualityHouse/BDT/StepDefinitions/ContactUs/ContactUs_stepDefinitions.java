package QualityHouse.BDT.StepDefinitions.ContactUs;


import com.n3.POM.QualityHouse.ContactUsClass;
import com.n3.POM.QualityHouse.HomePageClass;
import com.n3.POM.QualityHouse.factory.QualityHouse;

import com.n3.WD.support.DriverSvS;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import java.util.concurrent.TimeUnit;

public class ContactUs_stepDefinitions {

    private WebDriver driver;
    private DriverSvS services;
    private QualityHouse qualityHouse;


    public static final String requester_name = "Nikolay Nikolov";
    public static final String requester_email = "n3qa@abv.bg";
    public static final String request_subject = "UI Automation Demo project for Quality House LTD";
    public static final String request_message = "This is a simple UI Automation Test, which represents the working capabilities of Selenium 3.14+, BDt with Cucumber.IO  and Java code syntax";
    @FindBy(how = How.CSS, using = "div.body:nth-child(3) div.header-body div.header-container.container div.header-row div.header-column:nth-child(2) div.header-row:nth-child(2) div.header-nav.clearfix div.header-nav-main.header-nav-main-effect-1.header-nav-main-sub-effect-1.collapse nav:nth-child(1) ul.nav.nav-pills li.dropdown:nth-child(6) > a.dropdown-toggle")
    public WebElement nav_contactUs;


    public ContactUs_stepDefinitions(DriverSvS services, QualityHouse qualityHouse) {
        this.services = services;
        this.driver = services.getDriver();
        this.qualityHouse = qualityHouse;
    }


    @Given("An user launches the Quality House Home page with URL {string}")
    public void anUserLaunchesTheQualityHouseHomePageWithURL(String url) throws InterruptedException {
        driver.get(url);
        services.getWaitTool().waitForPageLoad();
        Assert.assertEquals(driver.getTitle(), "Home | Quality House Ltd.");

    }

    @When("The user clicks on the ContactUs navigation button")
    public void theUserClicksOnTheContactUsNavigationButton() {
        qualityHouse.homepage = new HomePageClass(driver);
        qualityHouse.homepage.navigate_to_ContactUs_Page();
        Assert.assertEquals(driver.getTitle(), "Contact Us | Quality House Ltd.");
    }

    @Then("Then the contactUs request massage form is presented")
    public void thenTheContactUsRequestMassageFormIsPresented() {
        qualityHouse.contactUsClassPage = new ContactUsClass(driver);
        qualityHouse.contactUsClassPage.checkContactUsPageURL();
        qualityHouse.contactUsClassPage.checkContactUsHeaderPage();
    }

    @When("The user populates the contact us request message form with valid data")
    public void theUserPopulateTheContactUsRequestMessageFormWithValidData() throws InterruptedException {
        qualityHouse.contactUsClassPage = new ContactUsClass(driver);
        qualityHouse.contactUsClassPage.enter_name(requester_name);
        qualityHouse.contactUsClassPage.enter_email(requester_email);
        qualityHouse.contactUsClassPage.enter_subject(request_subject);
        qualityHouse.contactUsClassPage.enter_subject(request_message);
    }

    @And("The user accepts GPDR and submits the message")
    public void theUserAcceptsGPDRAndSubmitsTheMessage() {
        qualityHouse.contactUsClassPage = new ContactUsClass(driver);
        qualityHouse.contactUsClassPage.contactUs_Form_GDPR_checkbox.click();
        qualityHouse.contactUsClassPage.contactUs_Form_SendMsg_button.click();
    }

    @Then("The request made by the contact us form is successfully sent")
    public void theRequestMadeByTheContactUsFormIsSuccessfullySent() {
        qualityHouse.contactUsClassPage = new ContactUsClass(driver);


    }


}
