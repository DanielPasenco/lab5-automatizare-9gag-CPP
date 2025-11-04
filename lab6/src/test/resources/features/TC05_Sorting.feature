Feature: TC-05 Sort products by price
  As a user
  I want to sort products by price
  So that I can find products in my budget

  Scenario: Sort products by price ascending
    Given I am on the mens page
    When I sort products by "Low to High"
    Then the product list should reload
    And products should be sorted by price ascending
    
  Scenario: Sort products by price descending
    Given I am on the mens page
    When I sort products by "High to Low"
    Then the product list should reload
    And products should be sorted by price descending
    
  Scenario: Verify first products after sorting
    Given I am on the mens page
    When I sort products by "Low to High"
    Then the first product should have the lowest price
    
  @DataTable
  Scenario Outline: Sort products using different options - Data Table
    Given I am on the mens page
    When I sort products by "<sortOption>"
    Then the products should be sorted "<expectedOrder>"
    And the sort order should match "<sortOption>"
    
    Examples:
      | sortOption   | expectedOrder |
      | Low to High  | ascending     |
      | High to Low  | descending    |
      | Default      | default       |
