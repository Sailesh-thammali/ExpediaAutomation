@android @web
Feature: Validate Stay Booking Functionality With Information

  Background:  Verify user can book stays
    Given user open application
    Then verify user is on home page
    When user clicks on stays option
    Then verify user is on stay search page
    When user enters "stay.city","stay.from.date","stay.to.date" and "stay.travellers"
    And clicks on search button
    Then verify user is on stay listing page
    When user clicks on first stay
    And clicks on reserve button and pay at property option
    Then verify user is on stay review page

  Scenario Outline: Verify user can book with invalid details
    When user fills "<stay.firstname>","<stay.lastname>" and "<stay.email>"
    And clicks on complete booking button
    Then verify error message is displayed
    Examples:
      | stay.firstname | stay.lastname | stay.email     |
      | John           | Greesham      | johnmail       |
      | 1234           | Greesham      | john@gmail.com |
      | John           | 245G          | john@gmail.com |


