package Pages;

import org.openqa.selenium.By;
import Base.Baseclass;
<<<<<<< HEAD
=======
import Utils.WaitUtils;
>>>>>>> e36f405 (Initial commit)

// Page object class for the Login Page
public class LoginPage extends Baseclass {
    // Locators
    private By usernameInput = By.name("username");
    private By passwordInput = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By forgotPasswordLink = By.xpath("//p[contains(@class, 'orangehrm-login-forgot-header')]");
    private By errorMessage = By.xpath("//p[contains(@class, 'oxd-alert-content-text')]");
<<<<<<< HEAD
    private By brandBrandingImage = By.xpath("//img[contains(@alt, 'company-branding')]");
    private By companyLogo = By.xpath("//div[@class='orangehrm-login-logo']//img");
    private By usernameRequiredError = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Username']]//span[contains(@class, 'oxd-input-field-error-message')]");
    private By passwordRequiredError = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Password']]//span[contains(@class, 'oxd-input-field-error-message')]");
=======
    private By brandBrandingImage = By.xpath("//img[@alt='company-branding']");
    private By companyLogo = By.xpath("//div[@class='orangehrm-login-logo']//img");
    private By usernameRequiredError = By.xpath(
            "//div[contains(@class, 'oxd-input-group')][.//label[text()='Username']]//span[contains(@class, 'oxd-input-field-error-message')]");
    private By passwordRequiredError = By.xpath(
            "//div[contains(@class, 'oxd-input-group')][.//label[text()='Password']]//span[contains(@class, 'oxd-input-field-error-message')]");
    private By loadingSpinner = By.xpath("//div[contains(@class, 'oxd-loading-spinner-container')]");
>>>>>>> e36f405 (Initial commit)

    // Login page actions
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
<<<<<<< HEAD
=======
        System.out.println("[INFO] Waiting for redirect to dashboard after login...");
        try {
            int timeout = Base.ConfigLoader.getInstance().getTimeout();
            org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver,
                    java.time.Duration.ofSeconds(timeout));
            wait.until(org.openqa.selenium.support.ui.ExpectedConditions.urlContains("dashboard"));
            System.out.println("[INFO] Redirect to dashboard completed successfully.");

            // Wait for dashboard loading spinner overlay to disappear
            WaitUtils.waitForInvisibility(loadingSpinner);
            System.out.println("[INFO] Dashboard loading spinner disappeared.");
        } catch (Exception e) {
            System.out.println("[WARNING] Timed out waiting for dashboard redirect or loader: " + e.getMessage());
        }
>>>>>>> e36f405 (Initial commit)
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

    public String getUsernameRequiredError() {
        return getText(usernameRequiredError);
    }

    public String getPasswordRequiredError() {
        return getText(passwordRequiredError);
    }
}
