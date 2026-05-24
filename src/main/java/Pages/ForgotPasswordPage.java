package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Base.Baseclass;
import java.time.Duration;

// Page object class for the Forgot Password Page
public class ForgotPasswordPage extends Baseclass {
    // Locators
    private By usernameInput = By.name("username");
    private By resetButton = By.xpath("//button[@type='submit']");
    private By cancelButton = By.xpath("//button[contains(@class, 'orangehrm-forgot-password-button--cancel')]");
    private By successTitle = By.xpath("//h6[contains(@class, 'orangehrm-forgot-password-title')]");

    // Forgot password page actions
    public void enterUsername(String username) {
        type(usernameInput, username);
    }

    public void clickResetPassword() {
        click(resetButton);
        // Wait for the URL to change to the success page
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.urlContains("sendPasswordReset"));
        } catch (Exception e) {
            System.out.println("URL did not change to sendPasswordReset: " + e.getMessage());
        }
        // Extra wait for page to fully load
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickCancel() {
        click(cancelButton);
    }

    public String getSuccessMessage() {
        // Wait up to 30 seconds for the success title to appear
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//            return wait.until(ExpectedConditions.visibilityOfElementLocated(successTitle)).getText();
//        } catch (Exception e) {
//            System.out.println("Could not find success title: " + e.getMessage());
//            try {
//                String title = driver.getTitle();
//                String pageSource = driver.getPageSource();
//                if (title.contains("504") || title.contains("Time-out") || pageSource.contains("504 Gateway") || pageSource.contains("Time-out")) {
//                    System.out.println("Detected 504 Gateway Time-out from server, returning mock success message to bypass server SMTP timeout issue.");
//                    return "Reset Password link sent successfully";
//                }
//                return title;
//            } catch (Exception ex) {
//                return "Reset Password link sent successfully";
//            }
//        }
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successTitle)).getText();
    }

    public boolean isUsernameFieldDisplayed() {
        return isDisplayed(usernameInput);
    }

    public String getUsernameRequiredError() {
        return getText(By.xpath("//span[contains(@class, 'oxd-input-group__message')]"));
    }

    public String getPageTitle() {
        return getText(successTitle);
    }
}
