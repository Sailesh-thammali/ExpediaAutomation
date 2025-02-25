@android @web
Feature: Validate Car Rental Functionality
  Scenario: Verify user can rent cars
    Given user open application
    Then verify user is on home page
    When user clicks on cars option
    Then verify user is on car search page
    When user enters "pickup.place","dropoff.place","pickup.date","dropOff.date","pickup.time" and "dropoff.time"
    And user clicks on search button
    Then verify user is on car listing page
    When user click on first car
    Then verify user is on car review page
    Then print car rental details