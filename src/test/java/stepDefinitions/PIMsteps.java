package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import Pages.PIMPage;
<<<<<<< HEAD
import java.io.File;
import java.nio.file.Files;
=======
>>>>>>> e36f405 (Initial commit)
import java.util.UUID;

// Step definitions for the PIM module features
public class PIMsteps {

    private PIMPage pimPage = new PIMPage();
    private static String capturedEmpId;
    private static String firstName;
    private static String middleName;
    private static String lastName;
    private static String profilePicPath;

    @Given("User navigates to the PIM module")
    public void user_navigates_to_pim() {
        pimPage.navigateToPIM();
    }

    @Then("User should see employee list table or search panel")
    public void user_should_see_employee_list_table_or_search_panel() {
        Assert.assertTrue(pimPage.isSearchPanelDisplayed());
    }

    @When("User clicks on the Add Employee tab")
    public void user_clicks_add_employee_tab() {
        pimPage.clickAddEmployee();
    }

    @When("User enters employee details: First Name {string}, Middle Name {string}, Last Name {string}")
    public void user_enters_employee_details(String fName, String mName, String lName) {
        firstName = fName;
        middleName = mName;
        lastName = lName + UUID.randomUUID().toString().substring(0, 5);
    }

    @When("User uploads profile picture from {string}")
    public void user_uploads_profile_picture(String picPath) {
        profilePicPath = picPath;
    }

    @When("User saves the new employee record")
    public void user_saves_new_employee_record() {
        capturedEmpId = pimPage.addEmployee(firstName, middleName, lastName, profilePicPath);
        System.out.println("Employee Created ID: " + capturedEmpId);
    }

    @Then("Employee should be saved and Employee ID should be captured")
    public void employee_should_be_saved_and_captured() {
        Assert.assertNotNull(capturedEmpId);
        Assert.assertFalse(capturedEmpId.isEmpty());
    }

    @When("User searches for employee by captured ID")
    public void user_searches_by_captured_id() {
        pimPage.searchEmployeeById(capturedEmpId);
    }

    @Then("User should find the employee in search results")
    public void user_should_find_employee_in_results() {
        Assert.assertTrue(pimPage.getSearchResultsCount() >= 1);
        Assert.assertEquals(pimPage.getFirstRowEmployeeId(), capturedEmpId);
    }

    @When("User edits employee nickname to {string}")
    public void user_edits_employee_nickname(String nickname) {
        pimPage.editEmployeeNickName(capturedEmpId, nickname);
    }

    @Then("Employee nickname should be updated to {string}")
    public void employee_nickname_should_be_updated(String expectedNickname) {
        pimPage.clickPersonalDetails();
        Assert.assertEquals(pimPage.getNickNameValue(), expectedNickname);
    }

    @When("User deletes the employee with captured ID")
    public void user_deletes_employee_with_captured_id() {
        pimPage.deleteEmployee(capturedEmpId);
    }

    @Then("User should not find the employee in search results")
    public void user_should_not_find_employee_in_results() {
        Assert.assertEquals(pimPage.getSearchResultsCount(), 0);
    }

    @When("User clicks on the employee profile picture to edit")
    public void user_clicks_profile_picture_to_edit() {
        pimPage.clickEditForEmployee(capturedEmpId);
        pimPage.clickProfileImage();
    }

    @When("User uploads and saves profile picture {string}")
    public void user_uploads_and_saves_profile_picture(String path) {
<<<<<<< HEAD
        File file = new File(path);
        boolean createdTemp = false;
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                Files.write(file.toPath(), new byte[]{0});
                createdTemp = true;
            } catch (Exception e) {
                System.out.println("Failed to create temporary file: " + e.getMessage());
            }
        }

        try {
            pimPage.uploadPhotograph(path);
        } finally {
            if (createdTemp && file.exists()) {
                file.delete();
            }
        }
=======
        pimPage.uploadPhotograph(path);
>>>>>>> e36f405 (Initial commit)
    }
}
