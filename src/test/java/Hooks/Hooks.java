package Hooks;

import Base.ConfigLoader;
import Base.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

// Hook to run before and after scenarios
public class Hooks {

    @Before
    public void setUp() {
<<<<<<< HEAD
=======
        Utils.ScenarioContext.clear();
>>>>>>> e36f405 (Initial commit)
        String browser = ConfigLoader.getInstance().getBrowser();
        boolean headless = ConfigLoader.getInstance().isHeadless();
        DriverSetup.setDriver(browser, headless);
        WebDriver driver = DriverSetup.getDriver();
        driver.get(ConfigLoader.getInstance().getUrl());
    }

    @After
    public void tearDown(Scenario scenario) {
<<<<<<< HEAD
        WebDriver driver = DriverSetup.getDriver();
        if (driver != null) {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName() + "_failure");
            }
            DriverSetup.quitDriver();
=======
        try {
            WebDriver driver = DriverSetup.getDriver();
            if (driver != null) {
                if (scenario.isFailed()) {
                    Utils.Screenshot.captureScreenshot(scenario.getName());
                    final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", scenario.getName() + "_failure");
                }
                DriverSetup.quitDriver();
            }
        } finally {
            Utils.ScenarioContext.clear();
>>>>>>> e36f405 (Initial commit)
        }
    }
}
