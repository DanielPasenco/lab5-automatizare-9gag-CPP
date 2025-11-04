Feature: TC-03 Verify product display and details
  As a user
  I want to see product information
  So that I can make informed purchasing decisions

  Scenario: Verify products display on mens page
    Given I am on the mens page
    Then the product list should be visible
    And products should have names displayed
    And products should have prices displayed
    And products should have images displayed
    
  Scenario: Open individual product page
    Given I am on the mens page
    When I click on the first product
    Then I should be redirected to product page
    And the product title should be displayed
    And the product price should be displayed
    
  Scenario: Verify product page elements
    Given I am on a product page
    Then the product image should be displayed
    And the product description should be displayed
    And the "Add to cart" button should be displayed
    
  Scenario: Navigate back to mens page
    Given I am on a product page
    When I click the "Back" button
    Then I should return to mens page
    
  Scenario: Negative - Access non-existent product
    Given I navigate to invalid product page
    Then I should see 404 error page
