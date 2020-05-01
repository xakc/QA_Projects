package com.webdriver.n3.TechTour.BDT.StepDefinitions.REG;


import com.n3.POM.TechTour.factory.TechTour;
import com.n3.WD.support.DriverSvS;
import com.n3.POM.TechTour.*;

import io.cucumber.java.en.Given;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

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

    @Given("The user launches the TER SignUp page with URL {string}")
    public void theUserLaunchesTheTERSignUpPageWithURL(String url) throws InterruptedException {
        driver.get(url);
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        Thread.sleep(9999);
    }

//    @Given("^The user launches the SafetyCard SignUp page with URL \"([^\"]*)\"$")
//    public void the_user_launches_the_SafetyCard_SignUp_page_with_URL(String url) throws Throwable {
//        driver.get(url);
//        String pageTitle = driver.getTitle();
//        Assert.assertEquals(pageTitle, "Register");
//        techTour.registrationPage = new RegistrationPageClass(driver);
//
//    }


    protected WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        return wait;
    }


}
