package pages.ghost;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GhostHomePage {

    private WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Resources')]")
    private WebElement resources;

    @FindBy(xpath = "//h5[contains(text(),'Community Forum')]")
    private WebElement forum;

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public GhostHomePage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);

    }

    public GhostForumPage goToForumPage() throws InterruptedException {
        resources.click();
        WebElement forum = driver.findElement(By.xpath("//h5[contains(text(),'Community Forum')]"));
        wait.until(ExpectedConditions.elementToBeClickable(forum));
        forum.click();

        return PageFactory.initElements(driver, GhostForumPage.class);
    }


}
