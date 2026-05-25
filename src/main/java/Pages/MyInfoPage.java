package Pages;

import org.openqa.selenium.By;
import Base.Baseclass;
import Utils.WaitUtils;

public class MyInfoPage extends Baseclass {
    // Menu
    private By myInfoMenuLink = By.xpath("//a[contains(@href, 'viewMyDetails')]");

    // Sub tabs
    private By personalDetailsTab = By.xpath("//a[text()='Personal Details']");
    private By contactDetailsTab = By.xpath("//a[text()='Contact Details']");

    // Personal Details Locators
    private By nickNameInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[contains(text(), \"Driver's License Number\")]]//input");
    private By otherIdInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Other Id']]//input");
    private By personalDetailsSaveButton = By.xpath("//h6[text()='Personal Details']/following::button[@type='submit'][1]");

    // Contact Details Locators
    private By street1Input = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Street 1']]//input");
    private By cityInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='City']]//input");
    private By stateInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='State/Province']]//input");
    private By zipInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Zip/Postal Code']]//input");
    private By mobileInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Mobile']]//input");
    private By contactDetailsSaveButton = By.xpath("//button[@type='submit']");

    // Actions
    public void navigateToMyInfo() {
        click(myInfoMenuLink);
        try {
            Thread.sleep(4000); // Wait for My Info module load
        } catch (InterruptedException ignored) {}
    }

    public boolean isMyInfoPageDisplayed() {
        return isDisplayed(personalDetailsTab);
    }

    public void updatePersonalDetails(String nickname, String otherId) {
        click(personalDetailsTab);
        try {
            Thread.sleep(2000); // Wait for Personal Details tab to fully load
        } catch (InterruptedException ignored) {}
        type(nickNameInput, nickname);
        type(otherIdInput, otherId);
        click(personalDetailsSaveButton);
        try {
            Thread.sleep(4000); // Wait for save confirmation toast
        } catch (InterruptedException ignored) {}
    }

    public String getNickname() {
        click(personalDetailsTab);
        try {
            Thread.sleep(2000); // Wait for Personal Details tab to fully load
        } catch (InterruptedException ignored) {}
        return WaitUtils.waitForVisibility(nickNameInput).getAttribute("value");
    }

    public String getOtherId() {
        click(personalDetailsTab);
        try {
            Thread.sleep(2000); // Wait for Personal Details tab to fully load
        } catch (InterruptedException ignored) {}
        return WaitUtils.waitForVisibility(otherIdInput).getAttribute("value");
    }

    public void updateContactDetails(String street1, String city, String state, String zip, String mobile) {
        click(contactDetailsTab);
        try {
            Thread.sleep(3000); // Wait for Contact Details sub-tab to fully load
        } catch (InterruptedException ignored) {}
        WaitUtils.waitForVisibility(street1Input); // Ensure form is ready
        
        type(street1Input, street1);
        type(cityInput, city);
        type(stateInput, state);
        type(zipInput, zip);
        type(mobileInput, mobile);
        click(contactDetailsSaveButton);
        try {
            Thread.sleep(4000); // Wait for save confirmation toast
        } catch (InterruptedException ignored) {}
    }

    public String getStreet1() {
        click(contactDetailsTab);
        try {
            Thread.sleep(3000); // Wait for sub-tab load
        } catch (InterruptedException ignored) {}
        return WaitUtils.waitForVisibility(street1Input).getAttribute("value");
    }

    public String getMobile() {
        click(contactDetailsTab);
        try {
            Thread.sleep(3000); // Wait for sub-tab load
        } catch (InterruptedException ignored) {}
        return WaitUtils.waitForVisibility(mobileInput).getAttribute("value");
    }
}
