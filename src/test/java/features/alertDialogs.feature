@Regression
Feature: Alert Dialog Page

  @AlertDialogs
  Scenario: Custom Title
    Given check that the opened app is the desired app
    When click "App" tab
    Then click "Alert Dialogs" tab
    Then click "List dialog" button
    Then choose any element on list
    Then verify alert message