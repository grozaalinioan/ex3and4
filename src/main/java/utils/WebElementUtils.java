package utils;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebElementUtils {

    public static void waitForElementByLocator(WebDriver driver, final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(120, TimeUnit.SECONDS)
                .pollingEvery(800, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
    }

    public static void waitAfterElementToBeDisplayed(WebDriver driver, final By locator, int timeWait, boolean... forceSleep) {
        WebDriverWait wait = new WebDriverWait(driver, timeWait);
        try {
            if (forceSleep != null && forceSleep.length > 0 && forceSleep[0] == true) {
                Thread.sleep(2000);
            }
            wait.until(new ExpectedCondition<WebElement>() {
                //            	int i = 0;
                public WebElement apply(WebDriver driver) {
                    WebElement element = driver.findElement(locator);
                    return element.isDisplayed() ? element : null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
