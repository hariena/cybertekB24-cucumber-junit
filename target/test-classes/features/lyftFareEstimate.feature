Feature: @lyft

  Scenario: Searching lyft fare details
  As a rider, I should be able to enter pickup and drop off locations so that i can see the estimated.

    Scenario: fare estimated using city
      Given User is on lyft fare estimate page
      When User enters "Mclean, VA" to pickup address
      And User enters "Woodbridge, VA" to  drop-off address
      And User click on get estimate button
      Then User should see estimated price

  Scenario: Fare estimate using empty should show error
    Given User is on lyft fare estimate page
    When User enters "" to pickup address
    And User enters "" to  drop-off address
    And User click on get estimate button
    Then User should see estimated price
    Then User should see error message