@Regression
Feature: Fragment

  @HideAndShow
  Scenario: Hide And Show
    Given check that the opened app is the desired app
    When click "App" tab
    Then click "Fragment" tab
    Then click "Hide and Show" tab
    Then click Hide button and button name is "Show"
    Then click Show button and button name is "Hide"


