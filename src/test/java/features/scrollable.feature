@Regression
Feature: Views

  @Scrollable
  Scenario: Scrollable
    Given check that the opened app is the desired app
    When click "Views" tab
    Then scroll to Tabs
    Then click "Tabs" tab
    Then click "5. Scrollable" tab
    Then tab to 30. TAB
    Then check tab content "Tab 30"
