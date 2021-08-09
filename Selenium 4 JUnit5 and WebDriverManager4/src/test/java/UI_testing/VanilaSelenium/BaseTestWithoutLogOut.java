package UI_testing.VanilaSelenium;
import com.n3qa.common.Browser;
import com.n3qa.common.UserActions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import com.n3qa.common.Browser;


public class BaseTestWithoutLogOut {
    UserActions actions = new UserActions();
     static Browser browser;

    public BaseTestWithoutLogOut() {
        browser = new Browser();
    }


    @BeforeAll
    public static void setUp() {
       browser.open("https://www.abv.bg/");
    }

    @AfterAll
    public static void tearDown() {

    }
}
