import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class TestGhost {

    @Test
    public void search_blog() {

        System.setProperty("webdriver.chrome.driver", "c:\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // a. Navigate to https://ghost.org/
        driver.get("https://ghost.org/");

        //b. Navigate to "Community Forum" section using the "Resources" menu.
        WebElement resources = driver.findElement(By.xpath("//span[contains(text(),'Resources')]"));
        resources.click();
        WebElement forum = driver.findElement(By.xpath("//h5[contains(text(),'Community Forum')]"));
        wait.until(ExpectedConditions.elementToBeClickable(forum));
        forum.click();

        //c. Search for “create new blog”
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-button")));
        driver.findElement((By.xpath(".//a[@href='/search']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-term"))).sendKeys("create new blog");

        //d. Open one of the search results
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("results")));
        List<WebElement> items = driver.findElements(By.xpath(".//li[@class='item']"));
        items.get(1).click();

        driver.close();
        driver.quit();
    }
}
