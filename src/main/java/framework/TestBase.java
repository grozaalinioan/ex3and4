package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "c:\\Selenium\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void navigateToURL(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
