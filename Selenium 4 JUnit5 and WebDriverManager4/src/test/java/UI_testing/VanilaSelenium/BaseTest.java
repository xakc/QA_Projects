package UI_testing.VanilaSelenium;
import com.n3qa.common.Browser;
import com.n3qa.common.UserActions;
import org.junit.jupiter.api.AfterEach;

public class BaseTest extends BaseTestWithoutLogOut{

    UserActions actions = new UserActions();
    Browser browser = new Browser();

    @AfterEach
    public void afterTest() {

        System.out.println("Im here");
    }
}