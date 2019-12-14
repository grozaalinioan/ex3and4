package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestBase {
    protected static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        getDriverPath();
        System.setProperty("webdriver.chrome.driver", getDriverPath());
        driver = new ChromeDriver();
    }

    public void navigateToURL(String url) {
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    private String getDriverPath() {
        InputStream inputStream = getClass()
                .getClassLoader().getResourceAsStream("driverPath.txt");
        InputStreamReader isReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(isReader);
        StringBuffer sb = new StringBuffer();
        String str = null;
        while (true) {
            try {
                if (!((str = reader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            sb.append(str);
        }
        return sb.toString();

    }


}
