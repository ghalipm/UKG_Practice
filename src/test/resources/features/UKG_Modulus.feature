@
Feature: Users verifying modules

  Scenario: users accessing the Product Suites sub title under Solution module
    Given user is on homepage
    When the user clicks on the Solution module
    Then the user should see the Product Suites sub title:
      | Product Suites          |
      | UKG Pro                 |
      | UKG Dimensions          |
      | UKG Ready               |
      | UKG HR Service Delivery |
      | See All Products        |


  Scenario: users accessing by solutions sub title under Solution module
    Given user is on homepage
    When the user clicks on the Solution module
    And the user should see By Solutions title and sub modules:
      | By Solution                 |
      | Human Capital Management    |
      | Workforce Management        |
      | Payroll                     |
      | Solutions For Your Industry |

  Scenario: accessing whyUKG modulus
    Given user is on homepage
    When the user clicks on the whyUKG module
    Then the user should see the "Why UKG?" header

  Scenario: accessing customers modulus
    Given user is on homepage
    When the user clicks on the Customers modulus
    Then the user should see the customers' list:
      | Customers                |
      | UKG Customer Experience |

# Crtl+Alt+L: alignes the columns

  Scenario: accessing partners modulus
    Given user is on homepage
    When the user clicks on the Partners modulus
    Then the user should see the partner's list:
      | UKG Marketplace           |
      | Resellers                 |
      | Service Partners          |
      | Technology Partners       |
      | Become a Partner          |


  Scenario: accessing about us modulus
    Given user is on homepage
    When the user clicks on the about us modulus
    Then the user should see the text About UKG

  Scenario: accessing contact modulus
    Given user is on homepage
    When the user clicks on the contact modulus
    Then the user should see the Contact UKG header



    # filling contact sales form
    # fill the forms under contact using Java Fakers!!!
  Scenario: users should be able fill contact sales form
    Given user is on homepage
    When the user clicks on the contact modulus
    Then the user should see the Contact Sales form
    Then user can fill the form with valid info and be able to send by clicking "LEARN MORE" button
    Then verify that user be able to see "contact-thank-you" message


  Scenario: accessing support modulus
    Given user is on homepage
    When the user clicks on the support modulus
    Then the user should see the UKG Support header

  Scenario: accessing blog modulus
    Given user is on homepage
    When the user clicks on the Blog modulus
    Then the user should see the UKG Blog header

  Scenario: accessing career modulus
    Given user is on homepage
    When the user clicks on the career modulus
    Then the user should see the  Search Jobs  header


  Scenario: accessing glob-Icon modulus
    Given user is on homepage
    When the user clicks on the globe modulus
    Then the user should see the languages  list:
      | English    |
      | Français   |
      | Nederlands |
      | Español    |
      | Deutsch    |
# Crtl+Alt+L: alignes the columns




