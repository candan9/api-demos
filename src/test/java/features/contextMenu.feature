@Regression
Feature: Fragment

  @ContextMenu
  Scenario: Context Menu
    Given check that the opened app is the desired app
    When click "App" tab
    Then click "Fragment" tab
    Then click "Context Menu" tab
    Then long press to button
    Then check "Menu A" and "Menu B" opened


