import framework.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.way2automation.Way2AutomationHomePage;

public class TestEx4Way2Automation extends TestBase {
    private Way2AutomationHomePage way2AutomationHomePage;

    @Test
    public void validateShownDate() {

        //  a. Navigate to http://way2automation.com/way2auto_jquery/index.php
        navigateToURL("http://way2automation.com/way2auto_jquery/index.php");
        way2AutomationHomePage = PageFactory.initElements(driver, Way2AutomationHomePage.class);

        /*
            b. Fill in the mandatory info and submit the form (pop-up registration form appears with no cookies from the page on first visit).
            c. Open the "Date picker" widget.
            d. Navigate to the "FORMAT DATE" section.
            e. Select today's date.
            f. Select the "ISO 8601" Format option.
            g. Validate the shown date against the current date.
         */
        way2AutomationHomePage
                .register()
                .goToDatePickerPage()
                .openFormatDate()
                .setTodayDate()
                .formatDateAsISO5601()
                .validateShownDate();


    }
}