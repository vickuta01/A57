Feature: Login feature

  Scenario: Login Successful
    Given I open Login Page
    When I enter valid email "agnes.albertusiak@testpro.io"
    And I enter valid password "4Ameryka4aska!"
    And I click submit
    Then I am logged in