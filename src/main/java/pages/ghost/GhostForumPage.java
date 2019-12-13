package pages.ghost;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebElementUtils;

import java.util.List;

public class GhostForumPage {

    @FindBy(id = "search-button")
    private WebElement searchButton;

    @FindBy(id = "search-term")
    private WebElement searchField;

    @FindBy(className = "results")
    private WebElement results;

    @FindBy(xpath = ".//li[@class='item']")
    private List<WebElement> items;

    private WebDriver driver;

    public GhostForumPage(WebDriver driver) {
        this.driver = driver;
    }

    public GhostForumPage searchData(String data) {
        WebElementUtils.waitForElementToBeVisible(driver, searchButton);
        searchButton.click();
        searchField.sendKeys(data);
        return PageFactory.initElements(driver, GhostForumPage.class);
    }

    public GhostForumPage openOneSearchResult() {
        WebElementUtils.waitForElementToBeVisible(driver, results);
        items.get(1).click();
        return PageFactory.initElements(driver, GhostForumPage.class);
    }
}
