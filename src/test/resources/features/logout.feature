Feature: User can logout


  Scenario Outline:
    Given user on login page
    And user login as a "<role>"
    And user on "<page>"
    And user logout
    Then user land on login page

    Examples:
      | role      | page      |
      | student   | books     |
      | librarian | dashboard |


