
Feature: Amazon Order Placement

  Scenario: Search and Add Product to Cart
    Given User is on the Amazon homepage
    When User searches for "pen"
    And User adds the product "Parker Frontier Matte Black Gold Trim Roller Ball Pen| Ink Color - Blue | Perfect For Employees | Unique Gifts For Entrepreneurs" to the cart
    Then The cart should contain 1 item
    And The cart should display the correct product name
    When User proceeds to checkout
    Then User should be on the checkout page
    
  Scenario: Search Product Independently
    Given User is on the Amazon homepage
    When User searches for a product
    Then Search results should be displayed