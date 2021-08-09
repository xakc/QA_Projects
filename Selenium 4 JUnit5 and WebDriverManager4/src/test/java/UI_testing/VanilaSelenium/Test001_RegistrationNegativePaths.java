package UI_testing.VanilaSelenium;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

@Feature("Registration")
public class Test001_RegistrationNegativePaths extends BaseTestWithoutLogOut {


    @Test
    @Description("Validate that user is unable proceed to Registration page without accept ABV GDPR Terms and Conditions")
    public void OnBlankFirstName_ClickRegisterButton_RegisterButtonIsDisabled() throws InterruptedException {


       System.out.println("Im here in the test");
       Thread.sleep(15000);
    }

}
