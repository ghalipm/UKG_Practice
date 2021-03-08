Feature: librarian can add and edit a new user

  Scenario: As a librarian, I should be able to add users from users page
    Given the user librarian is on the homepage
    When the user click users module
    Then user can add users with all valid info
    And user able to close the add user window with "close" button
    And Librarians able to edit user info

