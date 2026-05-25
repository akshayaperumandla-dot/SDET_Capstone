package cucumberrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepDefinitions", "Hooks"},
    plugin = {
        "pretty",
        "html:reports/cucumber-reports.html",
        "json:reports/cucumber.json"
    },
    monochrome = true
)
public class ChromeTestRunner extends AbstractTestNGCucumberTests {

    @org.testng.annotations.BeforeClass
    public void setupBrowser() {
        System.setProperty("browser", "chrome");
        System.out.println("Initialized TestNG browser parameter: chrome");
    }
}
