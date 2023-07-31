@Regression
Feature: Notification

  @IncomingMessage
  Scenario: Incoming Message
    Given check that the opened app is the desired app
    When click "App" tab
    Then click "Notification" tab
    Then click "IncomingMessage" tab
    Then click Show Notification button
    Then check notification detail context is similar
