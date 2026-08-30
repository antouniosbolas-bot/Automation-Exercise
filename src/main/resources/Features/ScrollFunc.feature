Feature: Scroll Up and Scroll Down
  Scenario: Verify Scroll Up using Arrow button and Scroll Down
    Given I am on any page with content
    When I scroll down
    And click the Arrow button
    Then the page should scroll to top

  Scenario: Verify Scroll Up without Arrow button
    Given I am on any page with content
    When I scroll down
    Then I should be able to scroll back up manually

