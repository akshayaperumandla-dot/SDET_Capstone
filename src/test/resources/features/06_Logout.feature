Feature: Logout Module

  As a logged-in user,
  I want to log out of the system
  So that my session is terminated and my account remains secure

  Background:
    Given User is logged in as "Admin" with password "admin123"

  Scenario: Scenario 25 - Verify logout functionality
    When User logs out successfully
    Then User should be redirected to the login page

  Scenario: Scenario 26 - Verify session termination after logout
    When User logs out successfully
    Then User session should be terminated
