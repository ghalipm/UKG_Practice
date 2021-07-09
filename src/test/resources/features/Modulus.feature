Feature: Users verifying several modules

  Scenario: users accessing Solution module
    Given user is on homepage
    When the user clicks on the Solution module
    Then the user should see the links:
    | UKG Solutions           |
    | UKG Pro                 |
    | UKG Dimensions          |
    | UKG Ready               |
    | UKG HR Service Delivery |

  Scenario: accessing whyUKG modulus
    Given user is on homepage
    When the user clicks on the whyUKG module
    Then the user should see the "Why UKG?" header

  Scenario: accessing customers modulus
    Given user is on homepage
    When the user clicks on the Customers modulus
    Then the user should see the UKG Customers header

  Scenario: accessing partners modulus
    Given user is on homepage
    When the user clicks on the Partners modulus
    Then the user should see the partner's list:
      | UKG Marketplace           |
      | Resellers                 |
      | Service Partners          |
      | Technology Partners       |

  Scenario: accessing about us modulus
    Given user is on homepage
    When the user clicks on the about us modulus
    Then the user should see the gartner logo

  Scenario: accessing contact modulus
    Given user is on homepage
    When the user clicks on the contact modulus
    Then the user should see the Contact UKG header

#Ayjamal version
# Feature: Accessing the different modules
#  @wip1
#Scenario: Users should be able to access the Solutions list
#  Given User is on the main page
#  When User click Solutions tab
#  Then User should see following names in the list
#    | UKG Solutions          |
#    | UKG Pro                |
#    | UKG Dimensions         |
#    | UKG Ready              |
#    | UKG HR Service Delivery|



