Feature: Bank account operations

  Scenario Outline: Customer wants to add money to his bank account
    Given customer bank account balance is set to <before>
    When customer adds <add>
    Then customer bank account balance is <after>

    Examples:
      | before | add  | after |
      | 10.0   | 5.0  | 15.0  |
      | 20.0   | 35.0 | 55.0  |
