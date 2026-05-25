Feature: Admin Module - User Management

  As an Admin user,
  I want to manage system users (add, search, edit, delete)
  So that I can control access to the application

  Background:
    Given User is logged in as "Admin" with password "admin123"
    And User navigates to the Admin module

  Scenario: Scenario 11 - Verify Admin page access after login
    Then User should see the Admin page search panel

  Scenario: Scenario 12 - Search user by username
    When User searches for username "Admin"
    Then User should find "Admin" in search results

  Scenario: Scenario 13 - Add a new user with valid details
    When User clicks on the Add user button
    And User fills and saves the user form with role "ESS", employee "a", status "Enabled", username "AutoUserBDD", and password "AdminPassword123!"
    Then User navigates to Admin page
    And User searches for username "AutoUserBDD"
    Then User should find "AutoUserBDD" in search results

  Scenario: Scenario 14 - Edit existing user details
    When User clicks edit for username "AutoUserBDD"
    And User updates user role to "Admin" and saves
    Then User navigates to Admin page
    And User searches for username "AutoUserBDD"
    Then User should find "AutoUserBDD" in search results

  Scenario: Scenario 15 - Delete an existing user
    When User deletes username "AutoUserBDD"
    And User searches for username "AutoUserBDD"
    Then User should not find "AutoUserBDD" in search results
