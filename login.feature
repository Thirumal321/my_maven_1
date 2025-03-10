Feature: Login Functionality

  @LoginTest
  Scenario: User logs in with valid credentials
    Given User is on the login page
    When User enters valid username and password
    And User clicks the login button
    Then User should see the success message