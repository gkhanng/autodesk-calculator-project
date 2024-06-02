@GC @regression
Feature: Calculator Search
  As a user,
  I want to search for the calculator component on Google,
  So that I can access and test its functionality.


      # For this "÷" sign => hold Alt down and type 0247 or alternatively use "/"


  @GC-1 @smoke
  Scenario: Searching for the calculator component
    Given I am on the Google homepage
    When I search for "calculator"
    Then user should see "calculator" in the title


    When I enter the number 12
    And Click the "+" operation button
    When I enter the number 3
    And Click the "=" operation button
    Then the result displayed should be "15"


    When I enter the number 8730
    And Click the "-" operation button
    When I enter the number 143
    And Click the "=" operation button
    Then the result displayed should be "8587"

  # negative test
    When I enter the number 3
    And Click the "*" operation button
    When I enter the number 3
    And Click the "=" operation button
    Then the result displayed should NOT be "30"



    When I enter the number 10
    And Click the "÷" operation button
    When I enter the number 2
    And Click the "=" operation button
    Then the result displayed should be "5"


    When I enter the number 5
    And Click the "+" operation button
    And Click the "CE" operation button
    Then the result displayed should be "5"


    When I enter the number 8
    And Click the "÷" operation button
    When I enter the number 0
    And Click the "=" operation button
    Then the result displayed should be "Infinity"


    When I enter the decimal number 3.5
    And Click the "+" operation button
    When I enter the decimal number 1.25
    And Click the "=" operation button
    Then the result displayed should be "4.75"


    When I enter the number 112
    And Click the "+" operation button
    When I enter the decimal number 1.25
    And Click the "=" operation button
    Then the result displayed should be "113.25"



