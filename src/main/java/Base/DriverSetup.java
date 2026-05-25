package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class DriverSetup {

    private static ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void setDriver(String browser, boolean headless) {

        WebDriver webDriver;

        if (browser == null || browser.isEmpty()) {

            browser =
                    ConfigLoader.getInstance()
                            .getBrowser();
        }

        System.out.println(
                "Initializing browser: "
                        + browser
                        + " (Headless: "
                        + headless
                        + ")"
        );

        // =========================
        // CHROME
        // =========================

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options =
                    new ChromeOptions();

            options.addArguments("--remote-allow-origins=*");

            options.addArguments("--window-size=1920,1080");

            options.addArguments("--disable-dev-shm-usage");

            options.addArguments("--no-sandbox");

            options.addArguments("--disable-gpu");

            if (headless) {

                options.addArguments("--headless=new");
            }

            webDriver =
                    new ChromeDriver(options);

        }

        // =========================
        // EDGE
        // =========================

        else if (browser.equalsIgnoreCase("edge")) {

            EdgeOptions options =
                    new EdgeOptions();

            options.addArguments("--window-size=1920,1080");

            options.addArguments("--disable-dev-shm-usage");

            options.addArguments("--no-sandbox");

            options.addArguments("--disable-gpu");

            if (headless) {

                options.addArguments("--headless=new");
            }

            webDriver =
                    new EdgeDriver(options);

        }

        // =========================
        // INVALID BROWSER
        // =========================

        else {

            throw new IllegalArgumentException(
                    "Unsupported browser: " + browser
            );
        }

        // =========================
        // MAXIMIZE ONLY NON-HEADLESS
        // =========================

        if (!headless) {

            webDriver.manage()
                    .window()
                    .maximize();
        }

        // =========================
        // PAGE LOAD TIMEOUT
        // =========================

        int timeout =
                ConfigLoader.getInstance()
                        .getTimeout();

        webDriver.manage()
                .timeouts()
                .pageLoadTimeout(Duration.ofSeconds(timeout));

        // =========================
        // DISABLE IMPLICIT WAIT
        // =========================

        webDriver.manage()
                .timeouts()
                .implicitlyWait(Duration.ZERO);

        driver.set(webDriver);
    }

    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();

            driver.remove();
        }
    }
}