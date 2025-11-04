Feature: TC-04 Quick View modal behaviour
  As a user
  I want to use Quick View functionality
  So that I can preview product details quickly

  Scenario: Open Quick View modal
    Given I am on the mens page
    When I click on Quick View for first product
    Then the Quick View modal should open
    And the modal content should load completely
    
  Scenario: Verify Quick View modal content
    Given Quick View modal is open
    Then the product title should be displayed in modal
    And the product price should be displayed in modal
    And the product image should be displayed in modal
    
  Scenario: Close Quick View modal
    Given Quick View modal is open
    When I click the close button
    Then the modal should close
    And I should be back on mens page
    
  Scenario: Negative - Quick View on different page
    Given I am on a different page
    Then Quick View modal should not open automatically
