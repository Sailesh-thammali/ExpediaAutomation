@web
Feature: Validate Filter Functionality In Stay Booking

  Background:  Verify user can book stays
    Given user open application
    Then verify user is on home page
    When user clicks on stays option
    Then verify user is on stay search page
    When user enters "stay.city","stay.from.date","stay.to.date" and "stay.travellers"
    And clicks on search button
    Then verify user is on stay listing page

  Scenario Outline:
    When user selects "<stay.filter>"
    Then verify hotels with only "<stay.filter>" is displayed
    Examples:
      | stay.filter |
      | Pool        |
      | Hot tub     |