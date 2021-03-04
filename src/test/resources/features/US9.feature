Feature: Show User functionality

  Scenario: verify user categories
    Given the user librarian is on the homepage
    When the user click users module
    And the user click user group dropdown
    Then the user should see the following user group dropdown options
      | ALL       |
      | Librarian |
      | Students  |
