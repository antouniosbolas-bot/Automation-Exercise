Feature: Shopping Cart
  @Ignore
  Scenario: View Items in cart
    Given I have added a product to cart
    When I go to Cart page
    Then I should see the product listed with description, price, quantity and total

  @Ignore
  Scenario: Remove products from cart
    Given I have added a product to cart
    When I remove a product
    Then the product should no longer appear in the cart

    






