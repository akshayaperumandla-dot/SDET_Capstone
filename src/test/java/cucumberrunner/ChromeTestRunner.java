package cucumberrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;

// Runner for Chrome browser execution
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepDefinitions", "Hooks"},
    plugin = {
        "pretty",
<<<<<<< HEAD
        "html:reports/cucumber-reports.html"
=======
        "html:reports/cucumber-reports.html",
        "json:reports/cucumber.json"
>>>>>>> e36f405 (Initial commit)
    },
    monochrome = true
)
public class ChromeTestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setupBrowser() {
        System.setProperty("browser", "chrome");
    }
}
