@smoke
Feature: Users verifying several modules
@wp1
  Scenario: users accessing the Product Suites sub title under Solution module
    Given user is on homepage
    When the user clicks on the Solution module
    Then the user should see the Product Suites sub title:
      | UKG Pro                 |
      | UKG Dimensions          |
      | UKG Ready               |
      | UKG HR Service Delivery |
      | See All Products        |

  @wp2
  Scenario: users accessing by solutions sub title under Solution module
    Given user is on homepage
    When the user clicks on the Solution module
    And the user should see By Solutions title and sub modules:
      | By Solution                 |
      | Human Capital Management    |
      | Workforce Management        |
      | Payroll                     |
      | Time and Attendance         |
      | Employee Scheduling         |
      | Solutions For Your Industry |
  @wp3
  Scenario: accessing whyUKG modulus
    Given user is on homepage
    When the user clicks on the whyUKG module
    Then the user should see the "Why UKG?" header

  @wp4
  Scenario: accessing customers modulus
    Given user is on homepage
    When the user clicks on the Customers modulus
    Then the user should see the customers list:
      | Customers               |
      | UKG Customer Experience |

    # Crtl+Alt+L: aligns the columns
  @wp5
  Scenario: accessing partners modulus
    Given user is on homepage
    When the user clicks on the Partners modulus
    Then the user should see the partner's list:
      | UKG Marketplace           |
      | Resellers                 |
      | Service Partners          |
      | Technology Partners       |
      | Become a Partner          |

  @wp6
  Scenario: accessing about us modulus
    Given user is on homepage
    When the user clicks on the about us modulus
    Then the user should see the text About UKG
  @wp7
  Scenario: accessing contact modulus
    Given user is on homepage
    When the user clicks on the contact modulus
    Then the user should see the Contact UKG header



    # filling contact sales form
    # fill the forms under contact using Java Fakers!!!
  @wp8
  Scenario: users should be able fill contact sales form
    Given user is on homepage
    When the user clicks on the contact modulus
    Then the user should see the Contact Sales form
    Then user can fill the form with valid info and be able to send by clicking LEARN MORE button
    Then verify that user be able to see "Thank You" message

  @wp9
  Scenario: accessing support modulus
    Given user is on homepage
    When the user clicks on the support modulus
    Then the user should see the UKG Support header
  @wp10
  Scenario: accessing blog modulus
    Given user is on homepage
    When the user clicks on the Blog modulus
    Then the user should see the UKG Blog header
  @wp11
  Scenario: accessing career modulus
    Given user is on homepage
    When the user clicks on the career modulus
    Then the user should see the  Search Jobs  header

  @wp12
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




