Feature: Users seeing several modules

  Scenario: students should have access to modules

    Given student login into library homepage
    Then the student should be able to see books modules:
    | Books           |
    | Borrowing Books |


  Scenario: librarians should have access to modules

    Given the user librarian is on the homepage
    Then the user should be able to see dashboard modules:
      | Dashboard |
      | Users     |
      | Books     |

  # In the xls file provided,  Librarian/Dashboard modules are different!!!

  # You wonder why your test keeps failing for no reason:
  # badly written or mistaken user story!
  # Pay attention to requirements/TCs (In real work, it should be better)
  # Write your scenarios with care!

  #    What we got:                              What is on the web:

    #  | Dashboard        |                      | Dashboard |
    #  | Books            |                      | Users     |
    #  | Borrowing Books  |                      | Books     |

