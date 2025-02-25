@api
Feature:Validate create token functionality

  Scenario: Verify user can get authorization token with valid credentials
    Given user wants to call "/auth" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "create_token.json"
    When user performs post call
    Then verify status code is 200


  Scenario Outline: Verify user cannot get an authorization token with invalid credentials
    Given user wants to call "/auth" end point
    And set header "Content-Type" to "application/json"
    And set the request body from file "create_token.json" with "<username>" and "<password>"
    When user performs post call
    Then verify status code is 200
    Then verify response body has a field "reason" is "Bad credentials"

    Examples:
      | username | password    |
      | admin    | invalid     |
      | Admin    | password123 |
      | admin    | PASSWORD123 |
      | invalid  | invalid123  |