package pages.ghost;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebElementUtils;

public class GhostHomePage {

    @FindBy(xpath = "//span[contains(text(),'Resources')]")
    private WebElement resources;

    @FindBy(xpath = "//h5[contains(text(),'Community Forum')]")
    private WebElement forum;

    private static String PAGE_URL = "https://ghost.org/";

    private WebDriver driver;

    public GhostHomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public GhostForumPage goToForumPage() {
        resources.click();
        WebElementUtils.waitForElementToBeClickable(driver, forum);
        forum.click();
        return new GhostForumPage(driver);
    }
}
