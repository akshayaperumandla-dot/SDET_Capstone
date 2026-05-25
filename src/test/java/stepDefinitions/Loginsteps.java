package stepDefinitions;

import Base.ConfigLoader;
import Base.DriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import Pages.LoginPage;

public class Loginsteps {

    private LoginPage loginPage = new LoginPage();

    @Given("User is on the OrangeHRM login page")
    public void user_is_on_login_page() {
        // Hooks already navigated to the base URL, but we can verify
        Assert.assertTrue(loginPage.isUsernameFieldDisplayed(), "Login page username field is not visible.");
    }

    @Then("User should see username and password input fields")
    public void user_should_see_username_and_password_fields() {
        Assert.assertTrue(loginPage.isUsernameFieldDisplayed(), "Username field is not displayed.");
        Assert.assertTrue(loginPage.isPasswordFieldDisplayed(), "Password field is not displayed.");
    }

    @Then("User should see the login button")
    public void user_should_see_login_button() {
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed.");
    }

    @Then("User should see the forgot password link")
    public void user_should_see_forgot_password_link() {
        Assert.assertTrue(loginPage.isForgotPasswordLinkDisplayed(), "Forgot password link is not displayed.");
    }

    @Then("User should see corporate logos and branding")
    public void user_should_see_logos_and_branding() {
        Assert.assertTrue(loginPage.isBrandBrandingImageDisplayed(), "Brand branding image is not displayed.");
        Assert.assertTrue(loginPage.isCompanyLogoDisplayed(), "Company logo is not displayed.");
    }

    @When("User enters valid username {string} and password {string}")
    public void user_enters_valid_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("User clicks on the login button")
    public void user_clicks_login() {
        loginPage.clickLogin();
    }

    @Then("User should be redirected to the dashboard page")
    public void user_should_be_redirected_to_dashboard() {
        Assert.assertTrue(loginPage.getCurrentUrl().contains("dashboard") || loginPage.isDisplayed(org.openqa.selenium.By.xpath("//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module')]")), "Dashboard redirection failed.");
    }

    @Then("User logs out successfully")
    public void user_logs_out_successfully() {
        loginPage.logout();
    }

    @Then("User should see error message {string}")
    public void user_should_see_error_message(String expectedError) {
        if (expectedError.equalsIgnoreCase("Required")) {
            Assert.assertEquals(loginPage.getUsernameRequiredError(), "Required", "Username Required validation error mismatch.");
            Assert.assertEquals(loginPage.getPasswordRequiredError(), "Required", "Password Required validation error mismatch.");
        } else {
            Assert.assertEquals(loginPage.getErrorMessage(), expectedError, "Credentials validation error mismatch.");
        }
    }

    @Then("User session should be terminated")
    public void user_session_should_be_terminated() {
        String dashboardUrl = ConfigLoader.getInstance().getUrl() + "web/index.php/dashboard/index";
        DriverSetup.getDriver().get(dashboardUrl);
        try {
            Thread.sleep(1500); // Wait for potential redirect
        } catch (InterruptedException ignored) {}
        Assert.assertTrue(loginPage.getCurrentUrl().contains("login"), "Session not terminated! Able to access dashboard after logout.");
        Assert.assertTrue(loginPage.isUsernameFieldDisplayed(), "Login page UI not displayed when accessing dashboard after logout.");
    }

    @Then("User should be redirected to the login page")
    public void user_should_be_redirected_to_login_page() {
        Assert.assertTrue(loginPage.getCurrentUrl().contains("login"), "Logout redirection failed. URL did not redirect to login page.");
        Assert.assertTrue(loginPage.isUsernameFieldDisplayed(), "Username field not displayed after logout.");
    }
}
