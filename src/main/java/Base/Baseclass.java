package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Utils.WaitUtils;

// Base class for Page Objects with basic helper methods
public class Baseclass {
    protected WebDriver driver;

    public Baseclass() {
        this.driver = DriverSetup.getDriver();
    }

    protected void click(By locator) {
        try {
            WaitUtils.waitForClickable(locator).click();
        } catch (Exception e) {
            System.out.println("Standard click failed on " + locator.toString() + ", trying JavaScript click.");
            try {
                org.openqa.selenium.WebElement element = driver.findElement(locator);
                org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
                js.executeScript("arguments[0].click()", element);
            } catch (Exception ex) {
                System.out.println("JavaScript click also failed: " + ex.getMessage());
                throw e; // throw the original exception
            }
        }
    }

    protected void type(By locator, String text) {
        WebElement element = WaitUtils.waitForVisibility(locator);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.BACK_SPACE);
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

    public void selectCustomDropdown(By dropdownLocator, String optionText) {
        click(dropdownLocator);
        try {
            Thread.sleep(1500); // Wait for dropdown options to open
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        By optionLocator = By.xpath("//div[@role='listbox' or contains(@class, 'oxd-select-dropdown')]//*[normalize-space(text())='" + optionText + "' or contains(text(), '" + optionText + "')]");
        try {
            WaitUtils.waitForClickable(optionLocator).click();
        } catch (Exception e) {
            System.out.println("Standard click failed on option, trying JavaScript click: " + e.getMessage());
            try {
                org.openqa.selenium.WebElement opt = driver.findElement(optionLocator);
                org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
                js.executeScript("arguments[0].click()", opt);
            } catch (Exception ex) {
                System.out.println("JavaScript click also failed: " + ex.getMessage());
                throw ex;
            }
        }
    }

    public void logout() {
        By userDropdown = By.xpath("//span[@class='oxd-userdropdown-tab']");
        By logoutLink = By.xpath("//a[text()='Logout']");
        click(userDropdown);
        click(logoutLink);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
