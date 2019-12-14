package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementUtils {

    public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {
        Wait<WebDriver> wait = wait(driver);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        Wait<WebDriver> wait = wait(driver);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private static Wait<WebDriver> wait(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait;
    }
}
