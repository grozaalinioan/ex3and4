package pages.way2automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.WebElementUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Way2AutomationDatepickerPage {

    @FindBy(linkText = "FORMAT DATE")
    private WebElement formatDateButton;

    @FindBy(tagName = "iframe")
    List<WebElement> iframes;

    @FindBy(id = "datepicker")
    private WebElement datepicker;

    @FindBy(xpath = "//td[contains(@class,'ui-datepicker-today')]")
    private WebElement todayDate;

    private WebDriver driver;

    public Way2AutomationDatepickerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Way2AutomationDatepickerPage openFormatDate() {
        formatDateButton.click();
        return this;
    }

    public Way2AutomationDatepickerPage setTodayDate() {
        for (WebElement iframe : iframes) {
            if (iframe.getAttribute("src").contains("datepicker/defult4.html")) {
                driver.switchTo().frame(iframe);
            }
        }
        WebElementUtils.waitForElementToBeVisible(driver, datepicker);
        datepicker.click();
        todayDate.click();
        return this;
    }

    public Way2AutomationDatepickerPage formatDateAsISO8601() {
        Select dropdownFormat = new Select(driver.findElement(By.id("format")));
        dropdownFormat.selectByVisibleText("ISO 8601 - yy-mm-dd");
        return this;
    }

    public Way2AutomationDatepickerPage validateShownDate() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String shownDate = (String) jse.executeScript("return arguments[0].value", datepicker);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = formatter.format(calendar.getTime());

        Assert.assertTrue(shownDate.equals(currentDate));
        return this;
    }

}
