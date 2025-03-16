@android @web
Feature: Validate Sign In With Valid And Invalid Credentials

  Background:
    Given user open application
    Then verify user is on home page
    When user click on sign in button
    Then verify user is on sign in page

  Scenario: Successful sign in with valid credentials
    When user enter "user.email","user.password" and clicks on signIn
    Then verify user signed in successfully

  Scenario Outline: Unsuccessful sign in with invalid email
    When user enter "<invalid.email>"
    And click on continue button
    Then verify error message is displayed "error.email.msg"
    Examples:
      | invalid.email         |
      | saileshcse0@gmail.com |
      | sailesh*@gmail.com    |
      | exex@gmail.com        |


  Scenario Outline: Unsuccessful sign in with invalid password
    When user enter valid email "user.email" and invalid password "<invalid.password>"
    Then verify error message is displayed "error.password.msg"
    Examples:
      | invalid.password |
      | Test@123         |
      | 12345            |
      | yoyo@2222        |
      | Tester@291       |




