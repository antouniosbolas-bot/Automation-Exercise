Feature: Checkout and Payment Process
  @Ignore
  Scenario: Place Order: Login before Checkout
    Given I am logged in and have items In cart
    When I proceed to Checkout
    Then I should see address details and order review
    And I should be able to Add comment and place Order and redirect to payment page
  @Ignore
  Scenario: Place Order: Register while Checkout
    Given I am a new user with items in cart
    When I register at Checkout and fill payment details
    Then the order should be placed successfully and Download Invoice
  @Ignore
  Scenario: Place Order: Register before Checkout
    Given I have registered and logged in
    When I proceed to Checkout and enter payment details
    Then the order should be placed successfully and Download Invoice




