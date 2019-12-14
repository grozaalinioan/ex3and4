package pages.way2automation;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.WebElementUtils;

import java.util.List;

public class Way2AutomationHomePage {

    @FindBy(id = "load_box")
    private WebElement registrationForm;

    @FindBy(xpath = ".//input[@name='name']")
    private WebElement nameField;

    @FindBy(xpath = ".//input[@name='phone']")
    private WebElement phoneField;

    @FindBy(xpath = ".//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = ".//input[@name='city']")
    private WebElement cityField;

    @FindBy(xpath = ".//input[@name='username']")
    private List<WebElement> usernameFields;

    @FindBy(xpath = ".//input[@name='password']")
    private List<WebElement> passwordFields;

    @FindBy(xpath = ".//input[@value='Submit']")
    private List<WebElement> submitButtons;

    @FindBy(linkText = "Widget")
    private WebElement widget;

    @FindBy(linkText = "Datepicker")
    private WebElement datepicker;

    private WebDriver driver;

    public Way2AutomationHomePage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://way2automation.com/way2auto_jquery/index.php");
    }

    public Way2AutomationHomePage register() {
        WebElementUtils.waitForElementToBeVisible(driver, registrationForm);
        String generatedData = RandomStringUtils.randomAlphanumeric(10);
        nameField.sendKeys("Alin Groza");
        phoneField.sendKeys("07123456789");
        emailField.sendKeys(generatedData + "@gmail.com");
        Select dropdownCountry = new Select(driver.findElement(By.name("country")));
        dropdownCountry.selectByVisibleText("Romania");
        cityField.sendKeys("Timisoara");
        usernameFields.get(1).sendKeys(generatedData);
        passwordFields.get(1).sendKeys(generatedData);
        submitButtons.get(1).click();
        return PageFactory.initElements(driver, Way2AutomationHomePage.class);
    }

    public Way2AutomationDatepickerPage goToDatePickerPage() {
        WebElementUtils.waitForElementToBeClickable(driver, widget);
        widget.click();
        datepicker.click();
        return PageFactory.initElements(driver, Way2AutomationDatepickerPage.class);
    }


}

