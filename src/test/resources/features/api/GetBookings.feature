@api
Feature: Validate Get Booking End Point

  Scenario: Verify user can get all bookings
    Given user wants to call "/booking" end point
    When user performs get call
    Then verify status code is 200

  Scenario Outline: Verify user can get booking by individual fields
    Given user wants to call "/booking" end point
    And set parameters "<field.name>" and "<field.value>"
    When user performs get call
    Then verify status code is 200
    And store "[0].bookingid" into "booking.id"
    Given user wants to call "/booking/@id" end point
    When user performs get call
    Then verify status code is 200
    And verify response body has a field "<field.name>" is "<field.value>"
    Examples:
      | field.name  | field.value |
      | firstname   | Jim         |
      | lastname    | Brown       |
      | depositpaid | true        |






