Feature: TC-02 Navigation through main menu
  As a user
  I want to navigate through the main menu
  So that I can access different sections of the site

  Scenario: Navigate to Home page
    Given I am on the homepage
    When I click on "Home" link
    Then I should be on the home page
    
  Scenario: Navigate to Mens page
    Given I am on the homepage
    When I click on "Mens" link
    Then I should be on the mens page
    And the URL should contain "mens"
    
  Scenario: Navigate to Womens page
    Given I am on the homepage
    When I click on "Womens" link
    Then I should be on the womens page
    And the URL should contain "womens"
    
  Scenario: Navigate to Contact page
    Given I am on the homepage
    When I click on "Contact" link
    Then I should be on the contact page
    And the URL should contain "contact"
    
  Scenario: Negative - Access invalid URL
    Given I am on the homepage
    When I navigate to invalid page "menns.html"
    Then I should see 404 error page
