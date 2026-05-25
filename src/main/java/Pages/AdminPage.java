package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Base.Baseclass;
import Utils.WaitUtils;

import java.util.List;

public class AdminPage extends Baseclass {
    // Left Menu Locator
    private By adminMenuLink = By.xpath("//a[contains(@href, 'viewAdminModule')]");

    // Search Locators
    private By searchUsernameInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Username']]//input");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By resetButton = By.xpath("//button[contains(@class, 'oxd-button--ghost')]");
    
    // Table Locators
    private By tableRows = By.xpath("//div[@class='oxd-table-body']/div[@class='oxd-table-card']");
    private By firstRowUsernameCell = By.xpath("//div[@class='oxd-table-body']/div[1]/div[@role='row']/div[2]");
    private By deleteConfirmButton = By.xpath("//button[contains(., 'Yes, Delete')]");

    // Add User Locators
    private By addButton = By.xpath("//button[contains(., 'Add') or contains(@class, 'oxd-button') and .//i[contains(@class, 'bi-plus')]]");
    private By userRoleDropdown = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='User Role']]//div[contains(@class, 'oxd-select-wrapper')]");
    private By employeeNameInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Employee Name']]//input");
    private By autocompleteOption = By.xpath("//div[@role='listbox']//div[contains(@class, 'oxd-autocomplete-option')]");
    private By statusDropdown = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Status']]//div[contains(@class, 'oxd-select-wrapper')]");
    private By usernameInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Username']]//input");
    private By passwordInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Password']]//input");
    private By confirmPasswordInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Confirm Password']]//input");
    private By saveButton = By.xpath("//button[@type='submit']");
    
    // Actions
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
            Thread.sleep(1500); // Wait for results to load
        } catch (InterruptedException ignored) {}
    }

    public String getFirstRowUsername() {
        return getText(firstRowUsernameCell);
    }

    public void clickAdd() {
        click(addButton);
    }

    public void fillAddUserForm(String role, String employeeName, String status, String username, String password) {
        selectCustomDropdown(userRoleDropdown, role);
        
        // Autocomplete search for Employee Name
        type(employeeNameInput, employeeName);
        try {
            Thread.sleep(2000); // Wait for autocomplete options to search
        } catch (InterruptedException ignored) {}
        click(autocompleteOption); // Click first option
        
        selectCustomDropdown(statusDropdown, status);
        type(usernameInput, username);
        type(passwordInput, password);
        type(confirmPasswordInput, password);
        click(saveButton);
        try {
            Thread.sleep(2000); // Wait for save and page transition
        } catch (InterruptedException ignored) {}
    }

    public void clickEditUser(String username) {
        searchUser(username);
        By editButtonLocator = By.xpath("//div[@class='oxd-table-card'][.//div[text()='" + username + "']]//button[.//i[contains(@class, 'bi-pencil-fill')]]");
        click(editButtonLocator);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ignored) {}
    }

    public void updateRoleAndSave(String newRole) {
        selectCustomDropdown(userRoleDropdown, newRole);
        click(saveButton);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {}
    }

    public void deleteUser(String username) {
        searchUser(username);
        By deleteButtonLocator = By.xpath("//div[@class='oxd-table-card'][.//div[text()='" + username + "']]//button[.//i[contains(@class, 'bi-trash')]]");
        click(deleteButtonLocator);
        click(deleteConfirmButton);
        try {
            Thread.sleep(2000); // Wait for delete
        } catch (InterruptedException ignored) {}
    }

    public int getSearchResultsCount() {
        try {
            List<WebElement> rows = getElements(tableRows);
            return rows.size();
        } catch (Exception e) {
            return 0;
        }
    }
}
