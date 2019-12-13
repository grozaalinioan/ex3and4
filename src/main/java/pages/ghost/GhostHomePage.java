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

    private WebDriver driver;

    public GhostHomePage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://ghost.org/");
    }

    public GhostForumPage goToForumPage() {
        resources.click();
        WebElementUtils.waitForElementToBeClickable(driver, forum);
        forum.click();
        return PageFactory.initElements(driver, GhostForumPage.class);
    }
}
