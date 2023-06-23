@suite
Feature: Activities component
TAI service only show content for the most recent tax code change, therefore we are also only able to show 1
Activity for the most recent tax code change.

#Your recent account activity
  Scenario: User logins to activities page and should see Your recent account activity page
    Given User login to the activity Login Page
    And User is on activity start page
    And User should see Your recent account activity in govuk-heading-l

#Your tax calculation
  Scenario: User logins to activities page and should see tax calculation for current year
    Given User login to the activity Login Page
    And User is on activity start page
    And User should see Your recent account activity in govuk-heading-l
    And User should see Your tax calculation text on activity page
    And User should see Your tax calculation for the 2022-2023 is now available in govuk-link--no-visited-state

#Latest Tax code change
  Scenario: User logins to activities page and should see latest tax code change if date outside current tax year (CY) but inside last 6 months
    Given User login to the activity Login Page
    And User is on activity start page
    And User should see Your recent account activity in govuk-heading-l
    And User should see Latest Tax code change text on activity page
    And User should see 15 March 2023 text on activity page
    And User should see Your tax code has changed - 3 text on activity page

#Latest Tax code change
  Scenario Outline:  User logins to activities page and should see latest tax code change if date inside current tax year (CY) and inside last 6 months
    And User is on activity start page
    And User should see Your recent account activity in govuk-heading-l
    And User should see Latest Tax code change text on activity page
    And the user sees text '<expected date>' on the page
    And the user sees text '<expected text>' on the page
    Examples:

      | expected date | expected text                                |
      | 14 June 2023  |  Your tax code has changed - 7 |
      | 13 May 2023   | Your tax code has changed - 1 |
      | 14 April 2023 | Your tax code has changed - 2 |
      | 7 April 2023  | Your tax code has changed - 6 |
      | 6 April 2023  | Your tax code has changed - 5  |
      | 5 April 2023  | Your tax code has changed - 4  |
      | 15 March 2023 | Your tax code has changed - 3 |

#Latest Tax code change
  Scenario: User logins to activities page and should not see if latest tax code change date outside current tax year (CY) and outside last 6 months
    Given User login to the activity Login Page
    And User is on activity start page
    And User should see Your recent account activity in govuk-heading-l
    And User should see Latest Tax code change text on activity page
    And User should not see 15 September 2022 text on activity page

#Latest Tax code change
  Scenario: User logins to activities page and activities should be display in reverse chronological order based on <date>
    Given User login to the activity Login Page
    And User is on activity start page
    And User should see Your recent account activity in govuk-heading-l
    And User should see Latest Tax code change text on activity page
    #And User should able see activities in as a reverse chronological order based on <date> (need to implemnet this)

#Recent Child Benefit payments
  Scenario Outline:  User logins to activities page, customer claiming Child Benefit for more than 5 months, paid monthly, shown last 5 payments (within last 6 months)
    And User is on activity start page
    And User should see Your recent account activity in govuk-heading-l
    And User should see Recent Child Benefit payments text on activity page
    And the user sees text '<expected date>' on the page
    And the user sees text '<expected text>' on the page
    Examples:

      | expected date | expected text               |
      | 13 May 2023   | HMRC paid you child benefit |
      | 14 April 2023 | HMRC paid you child benefit |
      | 6 April 2023  | HMRC paid you child benefit |
      | 5 April 2023  | HMRC paid you child benefit |
      | 15 March 2023 | HMRC paid you child benefit |


#Your PAYE income for the current tax year
  Scenario Outline: User logins to activities page and should see user PAYE income for the current tax year
    Given User login to the activity Login Page
    And User is on activity start page
    And User should see Your recent account activity in govuk-heading-l
    And User should see Your PAYE income for the current tax year text on activity page
    And the user sees text '<expected date>' on the page
    And the user sees text '<expected text>' on the page
    Examples:

      | expected date | expected text               |
      | 13 April 2023   | Central Perk Coffee Ltd paid you PAYE income |