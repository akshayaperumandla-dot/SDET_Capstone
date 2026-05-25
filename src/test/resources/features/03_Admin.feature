Feature: Admin Module - User Management

  As an Admin user,
<<<<<<< HEAD
  I want to manage system users (add, search, edit, delete)
=======
  I want to manage system users
>>>>>>> e36f405 (Initial commit)
  So that I can control access to the application

  Background:
    Given User is logged in as "Admin" with password "admin123"
<<<<<<< HEAD
    And User navigates to the Admin module
=======
    When User navigates to the Admin module
>>>>>>> e36f405 (Initial commit)

  Scenario: Scenario 11 - Verify Admin page access after login
    Then User should see the Admin page search panel

  Scenario: Scenario 12 - Search user by username
    When User searches for username "Admin"
    Then User should find "Admin" in search results

  Scenario: Scenario 13 - Add a new user with valid details
    When User clicks on the Add user button
<<<<<<< HEAD
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
=======
    And User fills and saves the user form with role "ESS", employee "Linda Anderson", status "Enabled", username "AutoUserBDD1", and password "AdminPassword123!"
    And User navigates to Admin page
    And User searches for username "AutoUserBDD1"
    Then User should find "AutoUserBDD1" in search results

  Scenario: Scenario 14 - Edit existing user details
    When User clicks on the Add user button
    And User fills and saves the user form with role "ESS", employee "Linda Anderson", status "Enabled", username "AutoUserBDD2", and password "AdminPassword123!"
    And User navigates to Admin page
    And User searches for username "AutoUserBDD2"
    And User clicks edit for username "AutoUserBDD2"
    And User updates user role to "Admin" and saves
    And User navigates to Admin page
    And User searches for username "AutoUserBDD2"
    Then User should find "AutoUserBDD2" in search results

  Scenario: Scenario 15 - Delete an existing user
    When User clicks on the Add user button
    And User fills and saves the user form with role "ESS", employee "Linda Anderson", status "Enabled", username "AutoUserBDD3", and password "AdminPassword123!"
    And User navigates to Admin page
    And User searches for username "AutoUserBDD3"
    And User deletes username "AutoUserBDD3"
    And User navigates to Admin page
    And User searches for username "AutoUserBDD3"
    Then User should not find "AutoUserBDD3" in search results
>>>>>>> e36f405 (Initial commit)
