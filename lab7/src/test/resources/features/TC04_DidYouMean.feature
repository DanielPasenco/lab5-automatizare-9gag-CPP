@GoogleSearch @DidYouMean
Feature: TC-04 Verify "Did you mean" suggestion
  As a user
  I want to search with typos or irrelevant terms
  So that Google suggests correct spelling

  Scenario: Misspelled search should show "Did you mean" suggestion
    Given I navigate to "https://www.google.co.in"
    When I search for "Seleniun WebDrvier"
    Then search results should be displayed
    And the "Did you mean" suggestion should be visible
    And the suggestion should contain correct spelling

  Scenario: Completely irrelevant search should show suggestion
    Given I navigate to "https://www.google.co.in"
    When I search for "asdfghjkl qwerty"
    Then search results should be displayed or suggestion shown
    And alternative search suggestions may be displayed
