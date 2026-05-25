package Utils;

import Base.DriverSetup;
import Base.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static WebDriverWait getWait() {
        WebDriver driver = DriverSetup.getDriver();
        int timeout = ConfigLoader.getInstance().getTimeout();
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

//    private static WebDriverWait getWait(int timeoutInSeconds) {
//        WebDriver driver = DriverSetup.getDriver();
//        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
//    }

    public static WebElement waitForVisibility(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForVisibility(WebElement element) {
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForClickable(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForPresence(By locator) {
        return getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static boolean waitForInvisibility(By locator) {
        return getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static boolean waitForTextToBePresent(By locator, String text) {
        return getWait().until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
}
