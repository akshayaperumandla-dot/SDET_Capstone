package Utils;

import Base.DriverSetup;
import Base.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

// Helper class for adding explicit waits to elements
public class WaitUtils {

    private static WebDriverWait getWait() {
        int timeout = ConfigLoader.getInstance().getTimeout();
        return new WebDriverWait(DriverSetup.getDriver(), Duration.ofSeconds(timeout));
    }

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
        try {
            getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean waitForTextToBePresent(By locator, String text) {
        try {
            getWait().until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
