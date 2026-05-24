package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Base.Baseclass;
import java.io.File;
import java.util.List;

// Page Object for PIM (Employee Management) Module
public class PIMPage extends Baseclass {
    // Locators
    private By pimMenuLink = By.xpath("//a[contains(@href, 'viewPimModule')]");
    private By addEmployeeTab = By.xpath("//a[text()='Add Employee']");
    private By firstNameInput = By.name("firstName");
    private By middleNameInput = By.name("middleName");
    private By lastNameInput = By.name("lastName");
    private By employeeIdInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Employee Id']]//input");
    private By fileUploadInput = By.xpath("//input[@type='file']");
    private By saveButton = By.xpath("//button[@type='submit']");
    private By searchEmpIdInput = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Employee Id']]//input");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By tableRows = By.xpath("//div[@class='oxd-table-body']/div[@class='oxd-table-card']");
    private By firstRowIdCell = By.xpath("//div[@class='oxd-table-body']/div[1]/div[@role='row']/div[2]");
    private By deleteConfirmButton = By.xpath("//button[contains(., 'Yes, Delete')]");
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
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isSearchPanelDisplayed() {
        return isDisplayed(searchEmpIdInput);
    }

    public String addEmployee(String firstName, String middleName, String lastName, String profilePicPath) {
        type(firstNameInput, firstName);
        type(middleNameInput, middleName);
        type(lastNameInput, lastName);

        String empId = driver.findElement(employeeIdInput).getAttribute("value");

        if (profilePicPath != null && !profilePicPath.isEmpty()) {
            File pic = new File(profilePicPath);
            if (pic.exists()) {
                driver.findElement(fileUploadInput).sendKeys(pic.getAbsolutePath());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        click(saveButton);
        try {
            Thread.sleep(6000); // Wait for redirect to details page
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return empId;
    }

    public void searchEmployeeById(String empId) {
        type(searchEmpIdInput, empId);
        click(searchButton);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getFirstRowEmployeeId() {
        return getText(firstRowIdCell);
    }

    public void editEmployeeNickName(String empId, String nickName) {
        searchEmployeeById(empId);
        By editButtonLocator = By.xpath("//div[@class='oxd-table-card'][.//div[text()='" + empId + "']]//button[.//i[contains(@class, 'bi-pencil-fill')]]");
        click(editButtonLocator);
        try {
            Thread.sleep(3000);
            // Scroll down to make sure Driver's License Number field is visible
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, 300)");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        type(nickNameInput, nickName);
        click(personalDetailsSaveButton);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getNickNameValue() {
        try {
            Thread.sleep(3000);
            // Scroll down to make sure the field is visible
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, 300)");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(nickNameInput).getAttribute("value");
    }

    public void deleteEmployee(String empId) {
        searchEmployeeById(empId);
        By deleteButtonLocator = By.xpath("//div[@class='oxd-table-card'][.//div[text()='" + empId + "']]//button[.//i[contains(@class, 'bi-trash')]]");
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

    public void clickEditForEmployee(String empId) {
        searchEmployeeById(empId);
        By editButtonLocator = By.xpath("//div[@class='oxd-table-card'][.//div[text()='" + empId + "']]//button[.//i[contains(@class, 'bi-pencil-fill')]]");
        click(editButtonLocator);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickProfileImage() {
        try {
            Thread.sleep(2000);
            org.openqa.selenium.WebElement img = driver.findElement(profileImage);
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()", img);
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Could not click profile image: " + e.getMessage());
        }
    }

    public void clickPersonalDetails() {
        click(personalDetailsTab);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void uploadPhotograph(String profilePicPath) {
        File pic = new File(profilePicPath);
        driver.findElement(fileUploadInput).sendKeys(pic.getAbsolutePath());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(saveButton);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
