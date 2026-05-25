package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import Pages.MyInfoPage;

import java.util.UUID;

public class MyInfosteps {

    private MyInfoPage myInfoPage = new MyInfoPage();
    private static String uniqueNickname;
    private static String uniqueOtherId;
    private static String savedStreet;
    private static String savedMobile;

    @Given("User navigates to the My Info module")
    public void user_navigates_to_my_info() {
        myInfoPage.navigateToMyInfo();
    }

    @Then("User should see the Personal Details sub-tab")
    public void user_should_see_personal_details_tab() {
        Assert.assertTrue(myInfoPage.isMyInfoPageDisplayed(), "My Info page Personal Details tab not displayed.");
    }

    @When("User updates personal details nickname {string} and other ID {string}")
    public void user_updates_personal_details(String nickname, String otherId) {
        uniqueNickname = nickname + UUID.randomUUID().toString().substring(0, 4);
        uniqueOtherId = otherId + UUID.randomUUID().toString().substring(0, 4);
        myInfoPage.updatePersonalDetails(uniqueNickname, uniqueOtherId);
    }

    @Then("Saved nickname should be {string} and other ID should be {string}")
    public void saved_nickname_and_other_id_should_match(String nickname, String otherId) {
        // Refresh page to check persistence
        myInfoPage.navigateToMyInfo();
        Assert.assertEquals(myInfoPage.getNickname(), uniqueNickname, "Nickname mismatch.");
        Assert.assertEquals(myInfoPage.getOtherId(), uniqueOtherId, "Other ID mismatch.");
    }

    @When("User updates contact details street {string}, city {string}, state {string}, zip {string}, and mobile {string}")
    public void user_updates_contact_details(String street, String city, String state, String zip, String mobile) {
        savedStreet = street;
        savedMobile = mobile;
        myInfoPage.updateContactDetails(street, city, state, zip, mobile);
    }

    @Then("Saved street should be {string} and mobile should be {string}")
    public void saved_street_and_mobile_should_match(String street, String mobile) {
        // Navigate back to My Info to verify contact sub-tab values
        myInfoPage.navigateToMyInfo();
        Assert.assertEquals(myInfoPage.getStreet1(), savedStreet, "Contact details Street 1 mismatch.");
        Assert.assertEquals(myInfoPage.getMobile(), savedMobile, "Contact details Mobile phone mismatch.");
    }
}
