Feature: User Signup, Login and Logout
  Scenario: Signup new user
    Given I open Signup and Login page
    When I fill name, email and password and submit
    Then User Should Redirect To FillingData Page



  Scenario: Login existing user with correct credentials
    Given I open Signup and Login page
    When I fill correct email and password and submit
    Then User should be redirected to Home Page

  Scenario: Login existing user with incorrect credentials
    Given I open Signup and Login page
    When I fill incorrect email or password and submit
    Then I should see an error message

  Scenario: Logout user
    Given I am logged in
    When I click Logout
    Then I should be logged out and Redirect To Login page





