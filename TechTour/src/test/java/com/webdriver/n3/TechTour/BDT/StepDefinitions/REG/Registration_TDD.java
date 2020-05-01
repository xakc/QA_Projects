package com.webdriver.n3.TechTour.BDT.StepDefinitions.REG;

import com.n3.POM.TechTour.factory.TechTour;
import com.n3.WD.support.DriverSvS;
import cucumber.api.java.en.When;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class Registration_TDD {

    private WebDriver driver;
    private DriverSvS services;
    private TechTour techTour;

    private String password;

    public Registration_TDD(DriverSvS services, TechTour techTour) {
        this.services = services;
        this.driver = services.getDriver();
        this.techTour = techTour;

    }

    @When("^The user valid/invalid First name as \"([^\"]*)\"$")
    public void the_user_valid_invalid_First_name_as(String name) throws Throwable {
        techTour.registrationPage.enter_first_name(name);
    }

    @When("^The user valid/invalid Last name as \"([^\"]*)\"$")
    public void the_user_valid_invalid_Last_name_as(String lastName) throws Throwable {
        techTour.registrationPage.enter_last_name(lastName);
    }

    @When("^The user valid/invalid email as \"([^\"]*)\"$")
    public void the_user_valid_invalid_email_as(String email) throws Throwable {
        String add_random_string = RandomStringUtils.randomAlphanumeric(3);
        techTour.registrationPage.enter_email(add_random_string+email);

    }

    @When("^The user valid/invalid phone as \"([^\"]*)\"$")
    public void the_user_valid_invalid_phone_as(String phone) throws Throwable {
        techTour.registrationPage.enter_phone(phone);
    }

    @When("^The user valid/invalid address as \"([^\"]*)\"$")
    public void the_user_valid_invalid_address_as(String address) throws Throwable {
        techTour.registrationPage.enter_address(address);
        Thread.sleep(3000);

    }

    @When("^The user valid/invalid username as \"([^\"]*)\"$")
    public void the_user_valid_invalid_username_as(String userName) throws Throwable {
        String add_random_string = RandomStringUtils.randomAlphanumeric(3);
        techTour.registrationPage.enter_userName(userName+add_random_string);

    }

    @When("^The user valid/invalid password as \"([^\"]*)\"$")
    public void the_user_valid_invalid_password_as(String pass) throws Throwable {
        techTour.registrationPage.enter_password(pass);
        password = pass;

    }




}
