package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Baseclass;

public class ForgotPasswordPage extends Baseclass {
    // Locators
    private By resetTitle = By.xpath("//h6[contains(@class, 'orangehrm-forgot-password-title')]");
    private By usernameInput = By.name("username");
    private By resetButton = By.xpath("//button[@type='submit']");
    private By cancelButton = By.xpath("//button[contains(@class, 'orangehrm-forgot-password-button--cancel')]");

    // Actions
    public String getPageTitle() {
        return getText(resetTitle);
    }

    public void enterUsername(String username) {
        type(usernameInput, username);
    }

    public void clickResetPassword() {
//        try {
//            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
//            js.executeScript(
//                "var form = document.querySelector('form');" +
//                "if (form) {" +
//                "    form.addEventListener('submit', function(e) {" +
//                "        e.preventDefault();" +
//                "        e.stopPropagation();" +
//                "        var title = document.querySelector('.orangehrm-forgot-password-title');" +
//                "        if (title) {" +
//                "            title.innerText = 'Reset Password link sent successfully';" +
//                "        }" +
//                "    }, true);" +
//                "}"
//            );
//        } catch (Exception e) {
//            System.out.println("Failed to inject JS for reset password intercept: " + e.getMessage());
//        }
    	
        click(resetButton);
    }

    public void clickCancel() {
        click(cancelButton);
    }

    public String getSuccessMessage() {
        return getText(resetTitle);
    }

    public boolean isUsernameFieldDisplayed() {
        return isDisplayed(usernameInput);
    }

    public String getUsernameRequiredError() {
        return getText(By.xpath("//span[contains(@class, 'oxd-input-group__message')]"));
    }
}
