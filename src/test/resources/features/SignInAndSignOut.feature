Feature: Validate Sign In And Sign Out Functionality
  Scenario: Verify User Can Sign In and sign out
    Given user open application
    Then verify user is on home page
    When user click on sign in button
    Then verify user is on sign in page
    When user enter "user.email","user.password" and clicks on signIn
    Then verify user signed in successfully
    When user clicks on account icon
    Then verify user is on account page
    When user click on sign out button
    Then verify user signed out successfully
