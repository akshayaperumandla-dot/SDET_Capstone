Feature: PIM Module - Employee Management

  As a HR Admin user,
  I want to manage employee records (add, search, edit, delete, and upload profile photo)
  So that employee database remains up to date

  Background:
    Given User is logged in as "Admin" with password "admin123"
    And User navigates to the PIM module

  Scenario: Scenario 16 - Add a new employee
    When User clicks on the Add Employee tab
    And User enters employee details: First Name "John", Middle Name "Test", Last Name "DoeBDD"
    And User saves the new employee record
    Then Employee should be saved and Employee ID should be captured

  Scenario: Scenario 17 - Search employee by ID
    When User searches for employee by captured ID
    Then User should find the employee in search results

  Scenario: Scenario 18 - Edit employee details
    When User edits employee nickname to "QABDD"
    Then Employee nickname should be updated to "QABDD"

  Scenario: Scenario 19 - Upload employee profile picture
    When User clicks on the employee profile picture to edit
    And User uploads and saves profile picture "src/test/resources/dummy.png"
    Then Employee nickname should be updated to "QABDD"

  Scenario: Scenario 20 - Delete employee record
    When User deletes the employee with captured ID
    And User searches for employee by captured ID
    Then User should not find the employee in search results
