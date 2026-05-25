package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import Pages.ForgotPasswordPage;
import Pages.LoginPage;

public class ForgotPasswordsteps {

    private LoginPage loginPage = new LoginPage();
    private ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @When("User clicks on the forgot password link")
    public void user_clicks_forgot_password() {
        loginPage.clickForgotPassword();
    }

    @Then("User should be redirected to the Reset Password page")
    public void user_should_be_redirected_to_reset_page() {
        Assert.assertTrue(forgotPasswordPage.getCurrentUrl().contains("requestPasswordResetCode"), "Failed to navigate to Reset Password page.");
    }

    @Then("User should see username input field on Reset page")
    public void user_should_see_username_input_field() {
        Assert.assertTrue(forgotPasswordPage.isUsernameFieldDisplayed(), "Username field not displayed on Reset page.");
    }

    @When("User enters username {string} on Reset page")
    public void user_enters_username_on_reset_page(String username) {
        forgotPasswordPage.enterUsername(username);
    }

    @When("User clicks on the reset password button")
    public void user_clicks_reset_password_button() {
        forgotPasswordPage.clickResetPassword();
    }

    @Then("User should see a success message {string}")
    public void user_should_see_success_message(String expectedMessage) {
        Assert.assertEquals(forgotPasswordPage.getSuccessMessage(), expectedMessage, "Password reset success message mismatch.");
    }

    @Then("User should see username field validation message {string}")
    public void user_should_see_username_field_validation_message(String expectedMessage) {
        Assert.assertEquals(forgotPasswordPage.getUsernameRequiredError(), expectedMessage, "Username validation error mismatch.");
    }
}
