Feature:As a user, I should be able to login to the library app.


  Scenario Outline:
    Given user on login page
    And user login as a "<role>"
    Then user on "<page>"


    Examples:
      | role      | page      |
      | student   | books     |
      | librarian | dashboard |