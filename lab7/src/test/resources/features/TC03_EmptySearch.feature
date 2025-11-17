@GoogleSearch @NegativeTest
Feature: TC-03 Verify empty search behavior
  As a user
  I want to test empty search
  So that nothing should happen when clicking search without input

  Scenario: Empty search should not navigate away from homepage
    Given I navigate to "https://www.google.co.in"
    When I click search button without entering any text
    Then I should remain on the Google homepage
    And the search box should still be empty
    And no search results should be displayed

  Scenario: Search with only spaces should be treated as empty
    Given I navigate to "https://www.google.co.in"
    When I search for "   "
    Then I should remain on the Google homepage
    And no search results should be displayed
