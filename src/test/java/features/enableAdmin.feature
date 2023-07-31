@Regression
Feature: Device Admin

  @EnableAdmin
  Scenario: Enable Admin
    Given check that the opened app is the desired app
    When click "App" tab
    Then click "Device Admin" tab
    Then click "General" title
    Then click Enable admin check box
    Then scroll to bottom
    Then activate button
    Then check Enable admin check box is checked

