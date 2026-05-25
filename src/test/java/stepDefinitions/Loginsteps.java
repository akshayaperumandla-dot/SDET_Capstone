package stepDefinitions;

import Base.ConfigLoader;
import Base.DriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import Pages.LoginPage;

// Step definitions for the Login features
public class Loginsteps {

    private LoginPage loginPage = new LoginPage();

    @Given("User is on the OrangeHRM login page")
    public void user_is_on_login_page() {
        Assert.assertTrue(loginPage.isUsernameFieldDisplayed(), "Username field is not visible.");
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
        Assert.assertTrue(loginPage.isBrandBrandingImageDisplayed(), "Brand image is not displayed.");
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
<<<<<<< HEAD
        boolean redirected = false;
        for (int i = 0; i < 15; i++) {
            if (loginPage.getCurrentUrl().contains("dashboard")) {
                redirected = true;
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Assert.assertTrue(redirected, "Not on dashboard page. Current URL: " + loginPage.getCurrentUrl());
=======
        Assert.assertTrue(loginPage.getCurrentUrl().contains("dashboard"), "Not on dashboard page.");
>>>>>>> e36f405 (Initial commit)
    }

    @Then("User logs out successfully")
    public void user_logs_out_successfully() {
        loginPage.logout();
    }

    @Then("User should see error message {string}")
    public void user_should_see_error_message(String expectedError) {
        if (expectedError.equalsIgnoreCase("Required")) {
            Assert.assertEquals(loginPage.getUsernameRequiredError(), "Required");
            Assert.assertEquals(loginPage.getPasswordRequiredError(), "Required");
        } else {
            Assert.assertEquals(loginPage.getErrorMessage(), expectedError);
        }
    }

    @Then("User session should be terminated")
    public void user_session_should_be_terminated() {
        String dashboardUrl = ConfigLoader.getInstance().getUrl() + "web/index.php/dashboard/index";
        DriverSetup.getDriver().get(dashboardUrl);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(loginPage.getCurrentUrl().contains("login"), "Able to access dashboard after logout.");
    }

    @Then("User should be redirected to the login page")
    public void user_should_be_redirected_to_login_page() {
<<<<<<< HEAD
        boolean redirected = false;
        for (int i = 0; i < 15; i++) {
            if (loginPage.getCurrentUrl().contains("login")) {
                redirected = true;
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Assert.assertTrue(redirected, "Not on login page. Current URL: " + loginPage.getCurrentUrl());
=======
        Assert.assertTrue(loginPage.getCurrentUrl().contains("login"), "Not on login page.");
>>>>>>> e36f405 (Initial commit)
    }
}
