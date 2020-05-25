Feature: Login to Administrator
  Scenario Outline: Show message with invalid credential
    Given The Login page was opened
    When The User attempt to login with invalid credential with <user> information
    Then The corresponding error message is showed for <user>
    Examples:
    |user|
    |user1|
    |user2|