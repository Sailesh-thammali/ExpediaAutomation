Feature:Validate on sort by functionality
  Background:
    Given user open application
    Then verify user is on home page
    When user clicks on flights option
    Then verify user is on flight search page
    When user clicks on one-way option
    And enters "from.city","to.city","date" and "1"
    And clicks on search button
    Then verify user is on flight listing page

  Scenario: Verify user can get all prices from high to low
    When user clicks on price high to low
    Then verify user can get prices in high to low

  Scenario: Verify user can get all prices from low to high
    When user clicks on price low to high
    Then verify user can get prices in low to high