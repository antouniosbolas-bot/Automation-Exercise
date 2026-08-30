Feature: Home Page Display and Subscription
  Scenario: Load Home Page and view Featured Items
    Given I Open Home Page
    When I should see the list of featured products with name and price
    Then  each product should have a View Product link


    Scenario: Subscribe from Home page
      Given I Open Home Page
      When I enter a valid email in subscription field and submit
      Then I should see confirmation that subscription is successful



