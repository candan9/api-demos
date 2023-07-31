@HomePage @Regression
Feature: Login Page

  @ActionBarTabs
  Scenario: Action Bar Tabs
    Given check that the opened app is the desired app
    When click "App" tab
    Then click "Action Bar" tab
    Then click "Action Bar Tabs" tab
    Then click Toggle tab mode button
    Then click 3 times Add new tab button
    Then check 3 tabs have been added
    Then click Remove last tab button
    Then check last tab deleted
    Then click Remove all tabs button
    Then check all tabs removed
