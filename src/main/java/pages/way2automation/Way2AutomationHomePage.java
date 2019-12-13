package pages.way2automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebElementUtils;

public class Way2AutomationHomePage {

    @FindBy(id = "load_box")
    private WebElement registrationForm;

    private WebDriver driver;

    public Way2AutomationHomePage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://way2automation.com/way2auto_jquery/index.php");
    }

    public Way2AutomationHomePage register() {
        WebElementUtils.waitForElementToBeVisible(driver, registrationForm);
        return PageFactory.initElements(driver, Way2AutomationHomePage.class);
    }
}

