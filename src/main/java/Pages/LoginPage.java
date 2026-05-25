package Pages;

import org.openqa.selenium.By;
import Base.Baseclass;

public class LoginPage extends Baseclass {
    // Locators
    private By usernameInput = By.name("username");
    private By passwordInput = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By forgotPasswordLink = By.xpath("//p[contains(@class, 'orangehrm-login-forgot-header')]");
    private By errorMessage = By.xpath("//p[contains(@class, 'oxd-alert-content-text')]");
    private By brandBrandingImage = By.xpath("//img[contains(@alt, 'company-branding')]");
    private By companyLogo = By.xpath("//div[@class='orangehrm-login-logo']//img");

    // Actions
    public void enterUsername(String username) {
        type(usernameInput, username);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public void clickForgotPassword() {
        click(forgotPasswordLink);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public boolean isUsernameFieldDisplayed() {
        return isDisplayed(usernameInput);
    }

    public boolean isPasswordFieldDisplayed() {
        return isDisplayed(passwordInput);
    }

    public boolean isLoginButtonDisplayed() {
        return isDisplayed(loginButton);
    }

    public boolean isForgotPasswordLinkDisplayed() {
        return isDisplayed(forgotPasswordLink);
    }

    public boolean isBrandBrandingImageDisplayed() {
        return isDisplayed(brandBrandingImage);
    }

    public boolean isCompanyLogoDisplayed() {
        return isDisplayed(companyLogo);
    }

    private By usernameRequiredError = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Username']]//span[contains(@class, 'oxd-input-field-error-message')]");
    private By passwordRequiredError = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Password']]//span[contains(@class, 'oxd-input-field-error-message')]");

    public String getUsernameRequiredError() {
        return getText(usernameRequiredError);
    }

    public String getPasswordRequiredError() {
        return getText(passwordRequiredError);
    }
}
