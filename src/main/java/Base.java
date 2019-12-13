import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
    protected static WebDriver driver;

    @BeforeMethod
    public void setUp()throws Exception{
        System.setProperty("webdriver.chrome.driver", "c:\\Selenium\\chromedriver\\chromedriver.exe");
        this.driver = new ChromeDriver();

        driver.get("https://ghost.org/");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
