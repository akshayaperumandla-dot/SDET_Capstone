Feature: Login Module

  As a user of OrangeHRM,
  I want to be able to log in with my credentials
  So that I can access the system dashboard

  Background:
    Given User is on the OrangeHRM login page

  Scenario: Scenario 1 - Login with valid username and password
    When User enters valid username "Admin" and password "admin123"
    And User clicks on the login button
    Then User should be redirected to the dashboard page
    And User logs out successfully

  Scenario: Scenario 2 - Login with invalid username
    When User enters username "InvalidUser" and password "admin123"
    And User clicks on the login button
    Then User should see error message "Invalid credentials"

  Scenario: Scenario 3 - Login with invalid password
    When User enters username "Admin" and password "wrongpassword"
    And User clicks on the login button
    Then User should see error message "Invalid credentials"

  Scenario: Scenario 4 - Login with blank credentials
    When User enters username "" and password ""
    And User clicks on the login button
    Then User should see error message "Required"

  Scenario: Scenario 5 - Verify all UI elements on Login page
    Then User should see username and password input fields
    And User should see the login button
    And User should see the forgot password link
    And User should see corporate logos and branding

  Scenario: Scenario 6 - Verify error message for invalid login
    When User enters username "Admin" and password "wrongpassword"
    And User clicks on the login button
    Then User should see error message "Invalid credentials"
