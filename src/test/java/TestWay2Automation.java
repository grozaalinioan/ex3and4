import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class TestWay2Automation {

    @Test
    public void validate_current_date() {

        System.setProperty("webdriver.chrome.driver", "c:\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        //a. Navigate to http://way2automation.com/way2auto_jquery/index.php
        driver.get("http://way2automation.com/way2auto_jquery/index.php  ");

        //b. Fill in the mandatory info and submit the form (pop-up registration form appears with no cookies from the page on first visit).
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("load_box")));
        String generatedData = RandomStringUtils.randomAlphanumeric(10);
        driver.findElement(By.xpath(".//input[@name='name']")).sendKeys("John Doe");
        driver.findElement(By.xpath(".//input[@name='phone']")).sendKeys("0723456789");
        driver.findElement(By.xpath(".//input[@name='email']")).sendKeys(generatedData + "@mail.com");
        Select dropdownCountry = new Select(driver.findElement(By.name("country")));
        dropdownCountry.selectByVisibleText("Romania");
        driver.findElement(By.xpath(".//input[@name='city']")).sendKeys("Timisoara" + "\t" + generatedData + "\t" + generatedData);
        //driver.findElement(By.xpath(".//input[@value='Submit']")).click();
        List<WebElement> submitButtons = driver.findElements(By.xpath(".//input[@value='Submit']"));
        submitButtons.get(1).click();

        //c. Open the "Date picker" widget.
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("load_box")));
        driver.findElement(By.linkText("Widget")).click();
        driver.findElement(By.linkText("Datepicker")).click();

        //d. Navigate to the "FORMAT DATE" section.
        driver.findElement(By.linkText("FORMAT DATE")).click();

        //e. Select today's date.
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        for (WebElement iframe : iframes) {
            System.out.println(iframe.getAttribute("src"));
            if (iframe.getAttribute("src").contains("datepicker/defult4.html")) {
                driver.switchTo().frame(iframe);
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("datepicker")));
        driver.findElement(By.id("datepicker")).click();
        driver.findElement(By.xpath(".//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-today']")).click();

        //f. Select the "ISO 8601" Format option.
        Select dropdownFormat = new Select(driver.findElement(By.id("format")));
        dropdownFormat.selectByVisibleText("ISO 8601 - yy-mm-dd");

        //g. Validate the shown date against the current date.
        WebElement datepicker = driver.findElement(By.xpath(".//*[@id='datepicker']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String shownDate = (String) jse.executeScript("return arguments[0].value", datepicker);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = formatter.format(calendar.getTime()).toString();

        Assert.assertTrue(shownDate.equals(currentDate));

        driver.close();
        driver.quit();
    }
}
