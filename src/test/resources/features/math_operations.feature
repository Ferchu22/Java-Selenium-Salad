## here describes the feature that is going to be tested
Feature: Cucumber Mathematics

  ## description of the test case → having 5 - 4 = 1
  Scenario: Let's eat cucumbers!
    Given I have 5 cucumbers
    When I eat 4 cucumbers
    Then I have 1 cucumber

    ## description of the test case → having 10 - 12 = ERROR, not recommended to see -2
  Scenario: Let's eat carrots!
    Given I have 10 carrots
    When I try to eat 3 carrots
    Then I should see the appropriate response

  ## description of the test case → creating salad and making the math of remaining veggies
  Scenario: Let's make a salad!
    Given I have 8 cucumbers
    And I have 5 carrots
    When I make a salad with 3 cucumbers and 2 carrots
    Then I have 5 cucumbers
    And I have 3 carrots
    And I have 1 salad