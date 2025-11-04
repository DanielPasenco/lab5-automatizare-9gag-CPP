Feature: TC-01 Verify homepage load and layout
  As a user
  I want to verify that the homepage loads correctly
  So that I can see all main elements

  Scenario: Verify homepage loads with all elements
    Given I am on the homepage
    Then the page should load successfully
    And the header should be displayed
    And the logo should be visible
    And the navigation menu should be displayed
    And the product list should be visible
    
  Scenario: Verify product images display
    Given I am on the homepage
    When the page loads completely
    Then product images should be displayed
    
  Scenario: Verify page has no layout errors
    Given I am on the homepage
    Then the page should not have visual errors
    And the layout should be stable
