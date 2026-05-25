Feature: My Info Module

  As an employee,
  I want to view and update my personal and contact details
  So that my profile information is correct and current

  Background:
    Given User is logged in as "Admin" with password "admin123"
    And User navigates to the My Info module

  Scenario: Scenario 21 - Verify My Info page access
    Then User should see the Personal Details sub-tab

  Scenario: Scenario 22 - Update personal details
    When User updates personal details nickname "BDDNick" and other ID "BDDID"
    Then Saved nickname should be "BDDNick" and other ID should be "BDDID"

  Scenario: Scenario 23 - Update contact details
    When User updates contact details street "456 BDD St", city "Test Town", state "Automation Land", zip "12345", and mobile "9876543210"
    Then Saved street should be "456 BDD St" and mobile should be "9876543210"

  Scenario: Scenario 24 - Save and verify updated information
<<<<<<< HEAD
    Then User should see the Personal Details sub-tab
    And User should be able to view contact details
=======
    Then Saved nickname should be "BDDNick" and other ID should be "BDDID"
    And Saved street should be "456 BDD St" and mobile should be "9876543210"
>>>>>>> e36f405 (Initial commit)
