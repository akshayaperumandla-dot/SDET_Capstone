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
<<<<<<< HEAD
            if (headless) {
                options.addArguments("--headless");
            }
=======
            options.addArguments("--remote-allow-origins=*");
            if (headless) {
                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
            }
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
>>>>>>> e36f405 (Initial commit)
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            if (headless) {
<<<<<<< HEAD
                options.addArguments("--headless");
            }
=======
                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
            }
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
>>>>>>> e36f405 (Initial commit)
            driver = new EdgeDriver(options);
        } else {
            driver = new ChromeDriver();
        }

<<<<<<< HEAD
        try {
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println("Could not maximize window: " + e.getMessage());
=======
        if (headless) {
            driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
        } else {
            driver.manage().window().maximize();
>>>>>>> e36f405 (Initial commit)
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
