@api
Feature: Verify End to End Scenario

  Scenario: Verify user can create, update and delete the booking
    Given user wants to call "/booking" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "create_booking.json"
    When user performs post call
    Then verify status code is 200
    And store "bookingid" into "booking.id"
    Given user wants to call "/auth" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "create_token.json"
    When user performs post call
    Then verify status code is 200
    And store "token" into "auth.token"
    Given user wants to call "/booking/@id" end point
    And set header "Content-Type" to "application/json"
    And set header "Cookie" to "token=@token"
    And set request body from file "update_booking.json"
    When user performs put call
    Then verify status code is 200
    Given user wants to call "/booking/@id" end point
    And set header "Cookie" to "token=@token"
    When user performs delete call
    Then verify status code is 201
    Given user wants to call "/booking/@id" end point
    When user performs get call
    Then verify status code is 404