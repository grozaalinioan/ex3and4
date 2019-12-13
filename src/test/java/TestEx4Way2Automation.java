import framework.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.way2automation.Way2AutomationHomePage;

public class TestEx4Way2Automation extends TestBase {
    private Way2AutomationHomePage way2AutomationHomePage;

    @Test
    public void validateCurrentDate() {
        navigateToURL("http://way2automation.com/way2auto_jquery/index.php");
        way2AutomationHomePage = PageFactory.initElements(driver, Way2AutomationHomePage.class);
        way2AutomationHomePage.register();
    }
}
