Feature: Contact Us Functionality
  Scenario: Submit contact us form
    Given I open Contact Us page
    When I fill Name, Email, Subject, Message and submit
    Then the form should be accepted or confirmation message shown
    Then User should be redirected to Home Page After Click Home Button





