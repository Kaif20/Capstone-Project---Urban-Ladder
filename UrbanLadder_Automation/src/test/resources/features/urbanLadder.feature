Feature: Urban Ladder Website Testing

  Scenario: Verify Home Page Sections
    Given I am on the Urban Ladder homepage
    Then I should see the Search Bar
    Then I should see the Search Button
    Then I should see the Top Offers section

  Scenario: Search for a product
    Given I am on the Urban Ladder homepage
    When I search for a product "Sofa"
    Then I should see search results displayed


  Scenario: Product Details Page
    Given I am on the Product Details page
    When I validate the product
    Then I should see the image of the product

  Scenario: User Registration and Login
    Given I am on the Urban Ladder homepage
    When I register a new user
    And I log in with valid credentials
    Then I should see my account settings