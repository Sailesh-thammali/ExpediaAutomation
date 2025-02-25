@android @web
Feature:Validate on filter functionality on flight details

  Background:
    Given user open application
    Then verify user is on home page
    When user clicks on flights option
    Then verify user is on flight search page
    When user clicks on one-way option
    And enters "from.city","to.city","date" and "travellers"
    And clicks on search button
    Then verify user is on flight listing page

  Scenario: Verify user can get flight details as per flight company filter
    When user selects the flight company "Air India"
    Then verify user can get all flights as selected company

  Scenario: Verify user can get flight details as per flight stops filter
    When user selects the flight stops "Direct"
    Then verify user can get all flights as selected stops