@GoogleSearch @Smoke
Feature: TC-01 Verify Google India page loads
  As a user
  I want to access Google India
  So that I can use Google search services

  Scenario: Google India page should load successfully
    Given I navigate to "https://www.google.co.in"
    Then the Google homepage should be displayed
    And the page title should contain "Google"
    And the search box should be visible
