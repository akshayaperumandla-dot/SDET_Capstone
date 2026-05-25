package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Base.Baseclass;
import Utils.WaitUtils;

import java.io.File;
import java.util.List;

public class PIMPage extends Baseclass {
    // Menu
    private By pimMenuLink = By.xpath("//a[contains(@href, 'viewPimModule')]");
    
    // Add Employee
    private By addEmployeeTab = By.xpath("//a[text()='Add Employee']");
    private By firstNameInput = By.name("firstName");
    private By middleNameInput = By.name("middleName");
    private By lastNameInput = By.name("lastName");
    private By employeeIdInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Employee Id']]//input");
    private By fileUploadInput = By.xpath("//input[@type='file']");
    private By saveButton = By.xpath("//button[@type='submit']");
    
    // Search Employee
    private By searchEmpIdInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Employee Id']]//input");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By tableRows = By.xpath("//div[@class='oxd-table-body']/div[@class='oxd-table-card']");
    private By firstRowIdCell = By.xpath("//div[@class='oxd-table-body']/div[1]/div[@role='row']/div[2]");
    private By deleteConfirmButton = By.xpath("//button[contains(., 'Yes, Delete')]");

    // Edit Employee details
    private By nickNameInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[contains(text(), \"Driver's License Number\")]]//input");
    private By personalDetailsSaveButton = By.xpath("//h6[text()='Personal Details']/following::button[@type='submit'][1]");
    private By profileImage = By.xpath("//div[@class='orangehrm-edit-employee-image']//img");
    private By personalDetailsTab = By.xpath("//a[text()='Personal Details']");
    
    // Actions
    public void navigateToPIM() {
        click(pimMenuLink);
    }

    public void clickAddEmployee() {
        click(addEmployeeTab);
        try {
            Thread.sleep(1500); // Wait for page load
        } catch (InterruptedException ignored) {}
    }

    public boolean isSearchPanelDisplayed() {
        return isDisplayed(searchEmpIdInput);
    }

    public String addEmployee(String firstName, String middleName, String lastName, String profilePicPath) {
        type(firstNameInput, firstName);
        type(middleNameInput, middleName);
        type(lastNameInput, lastName);
        
        // Capture auto-generated employee ID
        String empId = driver.findElement(employeeIdInput).getAttribute("value");
        
        // Upload photo if provided
        if (profilePicPath != null && !profilePicPath.isEmpty()) {
            File pic = new File(profilePicPath);
            driver.findElement(fileUploadInput).sendKeys(pic.getAbsolutePath());
            try {
                Thread.sleep(1500); // Let image load
            } catch (InterruptedException ignored) {}
        }
        
        click(saveButton);
        try {
            Thread.sleep(6000); // Wait for save and profile page redirect
        } catch (InterruptedException ignored) {}
        return empId;
    }

    public void searchEmployeeById(String empId) {
        type(searchEmpIdInput, empId);
        click(searchButton);
        try {
            Thread.sleep(1500); // Wait for results
        } catch (InterruptedException ignored) {}
    }

    public String getFirstRowEmployeeId() {
        return getText(firstRowIdCell);
    }

    public void editEmployeeNickName(String empId, String nickName) {
        // Assume we are on search page
        searchEmployeeById(empId);
        By editButtonLocator = By.xpath("//div[@class='oxd-table-card'][.//div[text()='" + empId + "']]//button[.//i[contains(@class, 'bi-pencil-fill')]]");
        click(editButtonLocator);
        try {
            Thread.sleep(3000); // Wait for personal details page
        } catch (InterruptedException ignored) {}
        
        type(nickNameInput, nickName);
        click(personalDetailsSaveButton);
        try {
            Thread.sleep(4000); // Wait for save
        } catch (InterruptedException ignored) {}
    }

    public String getNickNameValue() {
        return driver.findElement(nickNameInput).getAttribute("value");
    }

    public void deleteEmployee(String empId) {
        searchEmployeeById(empId);
        By deleteButtonLocator = By.xpath("//div[@class='oxd-table-card'][.//div[text()='" + empId + "']]//button[.//i[contains(@class, 'bi-trash')]]");
        click(deleteButtonLocator);
        click(deleteConfirmButton);
        try {
            Thread.sleep(2000); // Wait for deletion
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

    public void clickEditForEmployee(String empId) {
        searchEmployeeById(empId);
        By editButtonLocator = By.xpath("//div[@class='oxd-table-card'][.//div[text()='" + empId + "']]//button[.//i[contains(@class, 'bi-pencil-fill')]]");
        click(editButtonLocator);
        try {
            Thread.sleep(3000); // Wait for personal details page
        } catch (InterruptedException ignored) {}
    }

    public void clickProfileImage() {
        click(profileImage);
        try {
            Thread.sleep(2500); // Wait for page load
        } catch (InterruptedException ignored) {}
    }

    public void clickPersonalDetails() {
        click(personalDetailsTab);
        try {
            Thread.sleep(2500); // Wait for page load
        } catch (InterruptedException ignored) {}
    }

    public void uploadPhotograph(String profilePicPath) {
        File pic = new File(profilePicPath);
        driver.findElement(fileUploadInput).sendKeys(pic.getAbsolutePath());
        try {
            Thread.sleep(1500); // Let image load
            } catch (InterruptedException ignored) {}
        click(saveButton);
        try {
            Thread.sleep(4000); // Wait for save
        } catch (InterruptedException ignored) {}
    }
}
