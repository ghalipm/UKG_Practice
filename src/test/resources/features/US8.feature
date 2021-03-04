# if you write as "Feature", it will not work!
# It has to be "Feature:".  So ":" is very important!
# after Feature, Scenario, ":" is a must!
Feature: As a user, I should able to see my borrowed books.
@wip3
Scenario: borrowing books table columns names
Given the user student is on the homepage
When the user click Borrowing Books module
Then the user should see the following column names:
  | Action              |
  | Book Name           |
  | Borrowed Date       |
  | Planned Return Date |
  | Return Date         |
  | Is Returned ?       |
  # Make sure Scenario spelling is correct! For example:
  # Data and Date could be mixed up. Webpages are more correct than scenarios usually!