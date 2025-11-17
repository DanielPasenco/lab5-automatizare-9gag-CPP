@GoogleSearch @ResultsCount
Feature: TC-02 Verify search results count per page
  As a user
  I want to search on Google
  So that I can see how many results are displayed per page

  Scenario: Search results should display multiple items per page
    Given I navigate to "https://www.google.co.in"
    When I search for "Selenium WebDriver"
    Then search results should be displayed
    And I should see at least 5 results on the page
    And the results count should be visible
