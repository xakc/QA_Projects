package TechTour.BDT.StepDefinitions.REG;


import com.n3.POM.TechTour.RegistrationPageClass;
import com.n3.POM.TechTour.factory.TechTour;

import com.n3.WD.support.DriverSvS;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import java.util.concurrent.TimeUnit;

public class Registration_stepDefinitions {

    private WebDriver driver;
    private DriverSvS services;
    private TechTour techTour;

    private String password;

    public Registration_stepDefinitions(DriverSvS services, TechTour techTour) {
        this.services = services;
        this.driver = services.getDriver();
        this.techTour = techTour;

    }

    @Given("A not registered user launches the TER Sign up page with URL {string}")
    public void aNotRegisteredUserLaunchesTheTERSignUpPageWithURL(String url) {
        driver.get(url);
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);


        techTour.registrationPage = new RegistrationPageClass(driver);

    }

    @When("The user enters email as {string}")
    public void theUserEntersEmailAs(String email) throws InterruptedException {

        String add_random_string = RandomStringUtils.randomAlphanumeric(3);
        techTour.registrationPage.enter_email(add_random_string+email);
        Thread.sleep(700);

    }

    @When("The user enters password as {string}")
    public void theUserEntersPasswordAs(String password) {
        techTour.registrationPage.enter_password(password);
    }

    @When("The user clicks on the Sign up button")
    public void theUserClicksOnTheSignUpButton() {
        techTour.registrationPage.click_on_signUP_button();
    }


    @Then("The user is redirected to the Personal details event registration page")
    public void theUserIsRedirectedToThePersonalDetailsEventRegistrationPage() {

       boolean isFirstNameDisplayed =  techTour.registrationPage.REG_first_name_FIELD.isDisplayed();
        Assert.assertTrue(isFirstNameDisplayed,"The event registration page for personal details is not presented.");
    }

    @Then("The Sign up button is disabled")
    public void theSignUpButtonIsDisabled() {
    }


    @When("The user enters invalid email as {string}")
    public void theUserEntersInvalidEmailAs(String email) throws InterruptedException {
        techTour.registrationPage.enter_email(email);
        Thread.sleep(1300);
    }



    //Support methods
    protected WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        return wait;
    }

    @Then("An error message is presented as {string}")
    public void anErrorMessageIsPresentedAs(String expected_errorMSG) {

        //***  //p[contains(text(),'The email is already registered, use your password')]
        String txtLocator = expected_errorMSG;

        String error_msg_Xpath= "//p[contains(text(),'"+txtLocator+"')]";

        WebDriverWait wait =getWait();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(error_msg_Xpath))));

        String getErrorMSGtxt = driver.findElement(By.xpath(error_msg_Xpath)).getText();

        System.out.println(getErrorMSGtxt);

        Assert.assertEquals(getErrorMSGtxt,expected_errorMSG);
    }


}
