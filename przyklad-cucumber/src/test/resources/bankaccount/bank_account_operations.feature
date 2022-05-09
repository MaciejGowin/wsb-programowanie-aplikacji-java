Feature: Bank account operations

  Scenario: Customer wants to add money to his bank account
    Given customer bank account balance is set to 100.0
    When customer adds 50.0
    Then customer bank account balance is 150.0

  Scenario: Customer wants to add money to his bank account
    Given customer bank account balance is set to 17.0
    When customer adds 12.0
    Then customer bank account balance is 29.0
