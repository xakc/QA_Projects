package TechTour.BDT.Runners.Registration;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(

        features = "src/test/java/TechTour/BDT/Features/Registration/Registration.feature"
        ,glue = {
                    "TechTour.BDT.StepDefinitions.REG"
                    ,"com.n3.Cucumber"
                  }
                    ,monochrome = true
                    ,plugin = {
                            "pretty"
                            ,"html:D:\\CODES\\TechTour\\Reporting"
                          }
)

public class REG_Runner extends AbstractTestNGCucumberTests {
}



