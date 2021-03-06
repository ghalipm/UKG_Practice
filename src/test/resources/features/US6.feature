Feature: Student should see table column names
@wip6

  Scenario: Student should be able to see table column names
  Given student login into library homepage
  Then table should have following column names:
    | Actions     |
    | ISBN        |
    | Name        |
    | Author      |
    | Category    |
    | Year        |
    | Borrowed By |


