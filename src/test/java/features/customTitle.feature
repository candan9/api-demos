@Regression
Feature: ActivityPage

  @CustomTitle
  Scenario: Custom Title
    Given check that the opened app is the desired app
    When click "App" tab
    Then click "Activity" tab
    Then click "Custom Title" tab
    Then type left input "Right is best"
    Then click Change left button
    Then assert left section is changed as "Right is best"
    Then type right input "Left is always right"
    Then click Change right button
    Then assert right section is changed as "Left is always right"
