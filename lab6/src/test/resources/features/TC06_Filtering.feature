Feature: TC-06 Filter products by price
  As a user
  I want to filter products by price range
  So that I can find products within my budget

  Scenario: Apply valid price filter
    Given I am on the mens page
    When I filter products with min price "10" and max price "50"
    Then the product list should update
    And all displayed products should be within price range
    
  Scenario: Filter with minimum price only
    Given I am on the mens page
    When I filter products with min price "30" and max price ""
    Then products above 30 should be displayed
    
  Scenario: Filter with maximum price only
    Given I am on the mens page
    When I filter products with min price "" and max price "40"
    Then products below 40 should be displayed
    
  @DataTable
  Scenario Outline: Filter products with different price ranges - Data Table
    Given I am on the mens page
    When I filter products with min price "<minPrice>" and max price "<maxPrice>"
    Then the filtering result should be "<expectedResult>"
    And products should match the price criteria "<minPrice>" to "<maxPrice>"
    
    Examples:
      | minPrice | maxPrice | expectedResult    |
      | 10       | 50       | products shown    |
      | 20       | 30       | products shown    |
      | 100      | 200      | products shown    |
      | 1000     | 2000     | no products       |
      | 0        | 5        | no products       |
      
  Scenario: Reset filter by reloading page
    Given I have applied a price filter
    When I reload the page
    Then all products should be displayed again
    And the filter should be reset
    
  Scenario: Invalid price range - Negative test
    Given I am on the mens page
    When I filter with invalid range min "100" max "10"
    Then the system should handle invalid input
