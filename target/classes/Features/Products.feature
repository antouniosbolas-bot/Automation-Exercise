Feature: Products Listing and Search
  @Ignore
  Scenario: View all products list
    Given the user is on the Products page
    When the user enters a product name in the search field
    Then the search results should be displayed
  @Ignore
  Scenario: Filter products by Category or Brand
    Given I am on Products page
    When I filter products by a Category or Brand
    Then I should see only products matching that filter
  @Ignore
    Scenario: Verify That User Redirected to Cart Page After Adding Product and click View Cart
    Given I am on Products page
    When I add a product to cart And I click View Cart
    Then I should be redirected to Cart Page
  @Ignore
      Scenario: Verify That User Stay on Products Page After Adding Product and click Continue Shopping
        Given I am on Products page
        When I add a product to cart And I click Continue Shopping
        Then I should stay on Products Page

