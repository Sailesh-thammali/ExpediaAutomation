@web
Feature: Validate Car Rental Sort And Filter Functionality

  Background: : Verify user can rent cars
    Given user open application
    Then verify user is on home page
    When user clicks on cars option
    Then verify user is on car search page
    When user enters "pickup.place","dropoff.place","pickup.date","dropOff.date","pickup.time" and "dropoff.time"
    And user clicks on search button
    Then verify user is on car listing page

  Scenario: Verify user can get car details as per number of passengers filter
    When user selects the number of passengers "7"
    Then verify user gets all cars as selected number of passengers

  Scenario: Verify user can get all car prices from low to high
    When user clicks on price sort by low to high
    Then verify user can get car prices in low to high