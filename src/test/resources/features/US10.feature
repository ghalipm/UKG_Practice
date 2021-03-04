Feature: User status feature

  Scenario: user management table columns names

    Given the user librarian is on the homepage
    When the user click users module
    Then the user should see the following column names:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |

  Scenario: verify user status

    Given the user librarian is on the homepage
    When the user click users module
    And the user click Status dropdown
    Then the user should see the following options on user status:
      | ACTIVE   |
      | INACTIVE |
