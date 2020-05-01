package com.webdriver.n3.TechTour.BDT.Runners.Registration;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/java/SafetyCard/BDT/Features/Registration/Registration.feature"
        ,glue = {
        "SafetyCard.BDT.StepDefinitions.REG"
        ,"com.n3.Cucumber"
}
        ,dryRun = false
        ,monochrome = true
        ,plugin = {

        "pretty"
        ,"html:D:\\CODES\\M6\\V1_infoCucs\\Screenshot"

}
)

public class REG_Runner extends AbstractTestNGCucumberTests{
}



