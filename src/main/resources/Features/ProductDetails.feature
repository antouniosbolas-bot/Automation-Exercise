Feature: Product Details and Reviews
  @Ignore
  Scenario: View product details
    Given I on Products page
    When I click “View Product” for a product
    Then I should be redirected to Product Details Page

  @Ignore
  Scenario: Add a review for a product
    Given I am on a product’s detail page
    When I fill in “Your Name”, “Email Address”, “Add Review Here!” and submit
    Then the review should be accepted or a confirmation message shown


  @Ignore
   Scenario: Add product to cart
    Given I am on a product’s detail page
    When I click on “Add to cart” button and I click View Cart
    Then I should be redirected to Cart Page













