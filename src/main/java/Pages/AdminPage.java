package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Base.Baseclass;
import java.util.List;

// Page Object for the Admin Page
public class AdminPage extends Baseclass {
    // Locators
    private By adminMenuLink = By.xpath("//a[contains(@href, 'viewAdminModule')]");
    private By searchUsernameInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Username']]//input");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By resetButton = By.xpath("//button[contains(@class, 'oxd-button--ghost')]");
    private By tableRows = By.xpath("//div[@class='oxd-table-body']/div[@class='oxd-table-card']");
    private By firstRowUsernameCell = By.xpath("//div[@class='oxd-table-body']/div[1]/div[@role='row']/div[2]");
    private By deleteConfirmButton = By.xpath("//button[contains(., 'Yes, Delete')]");
    private By addButton = By.xpath("//button[contains(., 'Add')]");
    private By userRoleDropdown = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='User Role']]//div[contains(@class, 'oxd-select-wrapper')]");
    private By employeeNameInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Employee Name']]//input");
    private By autocompleteOption = By.xpath("//div[@role='listbox' or contains(@class, 'oxd-autocomplete-dropdown')]//*[contains(@class, 'oxd-autocomplete-option') or @role='option']");
    private By statusDropdown = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Status']]//div[contains(@class, 'oxd-select-wrapper')]");
    private By usernameInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Username']]//input");
    private By passwordInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Password']]//input");
    private By confirmPasswordInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Confirm Password']]//input");

    // Admin Page Actions
    public void navigateToAdmin() {
        click(adminMenuLink);
    }

    public boolean isAdminPageDisplayed() {
        return isDisplayed(searchUsernameInput);
    }

    public void searchUser(String username) {
        type(searchUsernameInput, username);
        click(searchButton);
        try {
            Thread.sleep(2000); // Wait for search results
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getFirstRowUsername() {
        return getText(firstRowUsernameCell);
    }

    public void clickAdd() {
        click(addButton);
    }

    public void fillAddUserForm(String role, String employeeName, String status, String username, String password) {
        selectCustomDropdown(userRoleDropdown, role);
        type(employeeNameInput, employeeName);
        try {
            Thread.sleep(2000); // Wait for hints
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(autocompleteOption);
        selectCustomDropdown(statusDropdown, status);
        type(usernameInput, username);
        type(passwordInput, password);
        type(confirmPasswordInput, password);
        click(By.xpath("//button[@type='submit']"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickEditUser(String username) {
        searchUser(username);
        By editButtonLocator = By.xpath("//div[@class='oxd-table-card'][.//div[text()='" + username + "']]//button[.//i[contains(@class, 'bi-pencil-fill')]]");
        click(editButtonLocator);
    }

    public void updateRoleAndSave(String newRole) {
        selectCustomDropdown(userRoleDropdown, newRole);
        click(By.xpath("//button[@type='submit']"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String username) {
        searchUser(username);
        By deleteButtonLocator = By.xpath("//div[@class='oxd-table-card'][.//div[text()='" + username + "']]//button[.//i[contains(@class, 'bi-trash')]]");
        click(deleteButtonLocator);
        click(deleteConfirmButton);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getSearchResultsCount() {
        try {
            List<WebElement> rows = driver.findElements(tableRows);
            return rows.size();
        } catch (Exception e) {
            return 0;
        }
    }
}
