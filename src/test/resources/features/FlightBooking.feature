@android @web
Feature: Validate Flight Booking Functionality

  Scenario: Verify user can book flights
    Given user open application
    Then verify user is on home page
    When user clicks on flights option
    Then verify user is on flight search page
    When user clicks on one-way option
    And enters "from.city","to.city","date" and "travellers"
    And clicks on search button
    Then verify user is on flight listing page
    When user clicks on first flight
    Then verify user is on review page
    And print flight details and price
