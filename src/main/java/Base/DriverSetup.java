package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.time.Duration;

// Simple browser driver setup class
public class DriverSetup {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(String browser, boolean headless) {
        if (browser == null || browser.isEmpty()) {
            browser = ConfigLoader.getInstance().getBrowser();
        }

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (headless) {
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            if (headless) {
                options.addArguments("--headless");
            }
            driver = new EdgeDriver(options);
        } else {
            driver = new ChromeDriver();
        }

        try {
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println("Could not maximize window: " + e.getMessage());
        }
        int timeout = ConfigLoader.getInstance().getTimeout();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
