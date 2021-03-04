Feature: As a user, I will be add and edit a new user

  Background:user navigates to login page
    Given user on login page

  Scenario: As a librarian, I should be able to add users from users page
    When user login as a "librarian"
    And user navigate to Users page
    And use add a new user
    Then user can edit new user