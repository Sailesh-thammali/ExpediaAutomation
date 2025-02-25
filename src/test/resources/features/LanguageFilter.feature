@android @web
Feature: Validate language filter functionality

  Scenario: Verify user can change region and language
    Given user open application
    Then verify user is on home page
    When user clicks on region button
    Then verify region options are displayed
    When user selects "region" and "language"
    And clicks on save button
    Then verify user selected language is displayed