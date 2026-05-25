Feature: Forgot Password Module

  As a user who forgot their password,
  I want to reset my password
  So that I can regain access to my account

  Background:
    Given User is on the OrangeHRM login page

  Scenario: Scenario 7 - Verify forgot password link navigation
    When User clicks on the forgot password link
    Then User should be redirected to the Reset Password page
    And User should see username input field on Reset page

  #Scenario: Scenario 8 - Reset password with valid username
   # When User clicks on the forgot password link
    #And User enters username "Admin" on Reset page
    #And User clicks on the reset password button
    #Then User should see a success message "Reset Password link sent successfully"

  Scenario: Scenario 9 - Reset password with invalid username
    When User clicks on the forgot password link
    And User enters username "InvalidUserReset" on Reset page
    And User clicks on the reset password button
    Then User should see a success message "Reset Password link sent successfully"

  #Scenario: Scenario 10 - Verify success message after reset
   # When User clicks on the forgot password link
    #And User enters username "Admin" on Reset page
    #And User clicks on the reset password button
    #Then User should see a success message "Reset Password link sent successfully"
