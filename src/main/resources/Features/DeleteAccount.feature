Feature: Delete Account
  @Ignore
  Scenario: User Can Delete Account
    Given I Open Home Page and looged in
    When I click Delete Account Button
    Then Account Deleted and Redirect To Account Deleted Page