Feature: Testing new asana project

  Scenario: Get workspace details
    Given I have workspace object
    When User performs GET workspace operation
    Then User is able to see the response with workspace details

  Scenario: Create a new project
    Given I have a new project object
    When User perform asana POST project
    Then User is able to see response with new project
