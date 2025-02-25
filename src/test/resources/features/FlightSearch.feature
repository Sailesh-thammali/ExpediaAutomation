@android @web
Feature: Validate Flight Searching Functionality

  Scenario Outline: Verify user can search flights with same source and destination
    Given user open application
    Then verify user is on home page
    When user clicks on flights option
    Then verify user is on flight search page
    When user clicks on one-way option
    And enters "<fromCity>" and "<toCity>"
    And clicks on search button
    Then verify error is displayed
    Examples:
      | fromCity | toCity |
      | Mumbai   | Mumbai |
      | Delhi    | Delhi  |
