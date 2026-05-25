package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import Utils.WaitUtils;

import java.util.List;

public class Baseclass {
    protected WebDriver driver;

    public Baseclass() {
        this.driver = DriverSetup.getDriver();
    }

    protected void click(By locator) {
        WaitUtils.waitForClickable(locator).click();
    }

    protected void click(WebElement element) {
        WaitUtils.waitForClickable(element).click();
    }

    protected void type(By locator, String text) {
        WebElement element = WaitUtils.waitForVisibility(locator);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return WaitUtils.waitForVisibility(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        try {
            return WaitUtils.waitForVisibility(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected List<WebElement> getElements(By locator) {
        WaitUtils.waitForPresence(locator);
        return driver.findElements(locator);
    }

    protected void hoverOverElement(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(WaitUtils.waitForVisibility(locator)).perform();
    }

    protected void selectCustomDropdown(By dropdownLocator, String optionText) {
        click(dropdownLocator);
        try {
            Thread.sleep(500); // Small pause for animation
        } catch (InterruptedException ignored) {}
        By optionLocator = By.xpath("//div[@role='listbox']//*[contains(text(), '" + optionText + "') or .//*[contains(text(), '" + optionText + "')]]");
        click(optionLocator);
    }

    public void logout() {
        By userDropdown = By.xpath("//span[@class='oxd-userdropdown-tab']");
        By logoutLink = By.xpath("//a[text()='Logout']");
        click(userDropdown);
        click(logoutLink);
        try {
            Thread.sleep(2000); // Wait for logout
        } catch (InterruptedException ignored) {}
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
