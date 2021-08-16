package QualityHouse.BDT.Runners.ContactUs;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(

        features = "src/test/java/QualityHouse/BDT/Features/ContactUS/ContactUs.feature"
        ,glue = {
                    "QualityHouse.BDT.StepDefinitions.ContactUs"
                    ,"com.n3.Cucumber"
                  }
                    ,monochrome = true
                    ,plugin = {
                            "pretty"
                            ,"html:D:\\CODES\\QualityHouse\\Reporting"
                          }
)

public class ContactUs_Runner extends AbstractTestNGCucumberTests {
}



