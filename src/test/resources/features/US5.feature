Feature: librarian could see book records
  @wip5
  # if "Scenario :" , it does not work, it must be "Scenario:"
  Scenario: librarian should be able to see book records on user page
    Given the user librarian is on the homepage
    # the above Given is already implemented somewhere.
    # if the wording of Given(statement) is different,
      # but the implementation content is the same
     # cucumber will block you doing any tests,
       # Ex: Given librarian login and on the homepage
       #     Given the user librarian is on the homepage
    # implementation: go to login page and librarian login

    When the user click users module
    Then show records default value should be '10'
    And show records should  have following count options:
      | 5     |
      | 10    |
      | 15    |
      | 50    |
      | 100   |
      | 200   |
      | 500   |
