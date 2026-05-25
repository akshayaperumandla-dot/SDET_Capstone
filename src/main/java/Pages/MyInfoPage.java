package Pages;

import org.openqa.selenium.By;
import Base.Baseclass;
<<<<<<< HEAD
//import Utils.WaitUtils;
=======
import Utils.WaitUtils;
>>>>>>> e36f405 (Initial commit)

// Page Object for the My Info Page
public class MyInfoPage extends Baseclass {
    // Locators
    private By myInfoMenuLink = By.xpath("//a[contains(@href, 'viewMyDetails')]");
    private By personalDetailsTab = By.xpath("//a[text()='Personal Details']");
    private By contactDetailsTab = By.xpath("//a[text()='Contact Details']");
<<<<<<< HEAD
    private By nickNameInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[contains(text(), \"Driver's License Number\")]]//input");
    private By otherIdInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Other Id']]//input");
    private By personalDetailsSaveButton = By.xpath("//h6[text()='Personal Details']/following::button[@type='submit'][1]");
    private By street1Input = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Street 1']]//input");
    private By cityInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='City']]//input");
    private By stateInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='State/Province']]//input");
    private By zipInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Zip/Postal Code']]//input");
=======
    private By nickNameInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Nickname']]//input");
    private By otherIdInput = By
            .xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Other Id']]//input");
    private By personalDetailsSaveButton = By.xpath("//div[contains(@class, 'orangehrm-card-container')][.//h6[text()='Personal Details']]//button[@type='submit']");
    private By street1Input = By
            .xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Street 1']]//input");
    private By cityInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='City']]//input");
    private By stateInput = By
            .xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='State/Province']]//input");
    private By zipInput = By
            .xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Zip/Postal Code']]//input");
>>>>>>> e36f405 (Initial commit)
    private By mobileInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Mobile']]//input");
    private By contactDetailsSaveButton = By.xpath("//button[@type='submit']");

    // Actions
    public void navigateToMyInfo() {
        click(myInfoMenuLink);
        try {
            Thread.sleep(4000); // Wait for My Info page to load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isMyInfoPageDisplayed() {
        return isDisplayed(personalDetailsTab);
    }

    public void updatePersonalDetails(String nickname, String otherId) {
        click(personalDetailsTab);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        type(nickNameInput, nickname);
        type(otherIdInput, otherId);
        click(personalDetailsSaveButton);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getNickname() {
        click(personalDetailsTab);
        try {
<<<<<<< HEAD
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(nickNameInput).getAttribute("value");
    }

    public String getOtherId() {
        return driver.findElement(otherIdInput).getAttribute("value");
=======
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return WaitUtils.waitForVisibility(nickNameInput).getAttribute("value");
    }

    public String getOtherId() {
        click(personalDetailsTab);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return WaitUtils.waitForVisibility(otherIdInput).getAttribute("value");
>>>>>>> e36f405 (Initial commit)
    }

    public void updateContactDetails(String street1, String city, String state, String zip, String mobile) {
        click(contactDetailsTab);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        type(street1Input, street1);
        type(cityInput, city);
        type(stateInput, state);
        type(zipInput, zip);
        type(mobileInput, mobile);
        click(contactDetailsSaveButton);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getStreet1() {
        click(contactDetailsTab);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD
        return driver.findElement(street1Input).getAttribute("value");
    }

    public String getMobile() {
        return driver.findElement(mobileInput).getAttribute("value");
    }

    public boolean isContactDetailsTabDisplayed() {
        return isDisplayed(contactDetailsTab);
=======
        return WaitUtils.waitForVisibility(street1Input).getAttribute("value");
    }

    public String getMobile() {
        click(contactDetailsTab);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return WaitUtils.waitForVisibility(mobileInput).getAttribute("value");
>>>>>>> e36f405 (Initial commit)
    }
}
