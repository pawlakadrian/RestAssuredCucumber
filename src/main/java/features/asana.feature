Feature: Testing new asana project

  Scenario: get workspace details
    Given i have workspace object
    When user performs GET workspace operation
    Then user is able to see the response with workspace details

Feature: Testing add new project to asana

  Scenario: post new project 
    Given i have a new project object
    When user perform asana POST project
    Then user is able to see response with new project
