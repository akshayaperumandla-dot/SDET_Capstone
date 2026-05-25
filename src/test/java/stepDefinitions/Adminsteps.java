package stepDefinitions;

//import Base.ConfigLoader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import Pages.AdminPage;
import Pages.LoginPage;

import java.util.UUID;

public class Adminsteps {

    private LoginPage loginPage = new LoginPage();
    private AdminPage adminPage = new AdminPage();
    private static String uniqueUsername;

    @Given("User is logged in as {string} with password {string}")
    public void user_is_logged_in_as_with_password(String username, String password) {
        loginPage.login(username, password);
    }

    @Given("User navigates to the Admin module")
    public void user_navigates_to_admin() {
        adminPage.navigateToAdmin();
    }

    @Then("User should see the Admin page search panel")
    public void user_should_see_admin_search_panel() {
        Assert.assertTrue(adminPage.isAdminPageDisplayed(), "Admin page search panel not displayed.");
    }

    @When("User clicks on the Add user button")
    public void user_clicks_add_user() {
        adminPage.clickAdd();
    }

    @When("User fills and saves the user form with role {string}, employee {string}, status {string}, username {string}, and password {string}")
    public void user_fills_and_saves_user_form(String role, String employee, String status, String username, String password) {
        // Append unique identifier to username to prevent conflicts
        uniqueUsername = username + UUID.randomUUID().toString().substring(0, 5);
        adminPage.fillAddUserForm(role, employee, status, uniqueUsername, password);
    }

    @Then("User navigates to Admin page")
    public void user_navigates_to_admin_page() {
        adminPage.navigateToAdmin();
    }

    @Then("User searches for username {string}")
    public void user_searches_for_username(String username) {
        if (username.equalsIgnoreCase("Admin")) {
            adminPage.searchUser("Admin");
        } else {
            adminPage.searchUser(uniqueUsername);
        }
    }

    @Then("User should find {string} in search results")
    public void user_should_find_user_in_search_results(String username) {
        Assert.assertTrue(adminPage.getSearchResultsCount() >= 1, "User not found in search results.");
        String expectedUsername = username.equalsIgnoreCase("Admin") ? "Admin" : uniqueUsername;
        Assert.assertEquals(adminPage.getFirstRowUsername(), expectedUsername, "Search result username mismatch.");
    }

    @When("User clicks edit for username {string}")
    public void user_clicks_edit_for_username(String username) {
        adminPage.clickEditUser(uniqueUsername);
    }

    @When("User updates user role to {string} and saves")
    public void user_updates_role_and_saves(String newRole) {
        adminPage.updateRoleAndSave(newRole);
    }

    @When("User deletes username {string}")
    public void user_deletes_username(String username) {
        adminPage.deleteUser(uniqueUsername);
    }

    @Then("User should not find {string} in search results")
    public void user_should_not_find_username_in_results(String username) {
        Assert.assertEquals(adminPage.getSearchResultsCount(), 0, "Deleted user still exists in search results.");
    }
}
