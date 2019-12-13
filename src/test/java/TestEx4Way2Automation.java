import framework.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.way2automation.Way2AutomationHomePage;

public class TestEx4Way2Automation extends TestBase {
    private Way2AutomationHomePage way2AutomationHomePage;

    @Test
    public void validateCurrentDate() {

        //a. Navigate to http://way2automation.com/way2auto_jquery/index.php
        navigateToURL("http://way2automation.com/way2auto_jquery/index.php");

        //b. Fill in the mandatory info and submit the form (pop-up registration form appears with no cookies from the page on first visit).
        way2AutomationHomePage = PageFactory.initElements(driver, Way2AutomationHomePage.class);
        way2AutomationHomePage.register();
    }
}