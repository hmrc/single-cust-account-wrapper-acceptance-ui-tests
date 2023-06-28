@suite
Feature: Activities component
TAI service only show content for the most recent tax code change, therefore we are also only able to show 1
Activity for the most recent tax code change.

#Your recent account activity
  Scenario: User logins to activities page and should see Your recent account activity page
    Given User login to the activity Login Page
    And User is on activity start page
    And User should able to see Your recent account activity in govuk-heading-l


#Your tax calculation
  Scenario: User logins to activities page and should see tax calculation for current year
    Given User login to the activity Login Page
    And User is on activity start page
    And User should able to see Your recent account activity in govuk-heading-l
    And the user should sees text Your tax calculation on the page
    And User should able to see Your tax calculation for the 2022-2023 is now available in govuk-link--no-visited-state


#Latest Tax code change
  Scenario: User logins to activities page and should see latest tax code change if date outside current tax year (CY) but inside last 6 months
    Given User login to the activity Login Page
    And User is on activity start page
    And User should able to see Your recent account activity in govuk-heading-l
    And User should see test text on activity page
    And the user should sees text Your tax code has changed - 3 on the page

#Latest Tax code change
  Scenario: User logins to activities page and should see latest tax code change if date inside current tax year (CY) and inside last 6 months
    Given User login to the activity Login Page
    And User is on activity start page
    And User should able to see Your recent account activity in govuk-heading-l
    And the user sees text as a Your tax code has changed - 7 date on the page
    And the user sees text as a Your tax code has changed - 6 date on the page
    And the user sees text as a Your tax code has changed - 5 date on the page
    And the user sees text as a Your tax code has changed - 4 date on the page
    And the user sees text as a Your tax code has changed - 3 date on the page
    And the user sees text as a Your tax code has changed - 2 date on the page
    And the user sees text as a Your tax code has changed - 1 date on the page

#Latest Tax code change
  Scenario: User logins to activities page and should not see if latest tax code change date outside current tax year (CY) and outside last 6 months
    Given User login to the activity Login Page
    And User is on activity start page
    And User should able to see Your recent account activity in govuk-heading-l
    And User should not see 15 September 2022 text on activity page

#Recent Child Benefit payments
  Scenario:  User logins to activities page, customer claiming Child Benefit for more than 5 months, paid monthly, shown last 5 payments (within last 6 months)
    And User is on activity start page
    And User should able to see Your recent account activity in govuk-heading-l
    And the user should sees text Recent Child Benefit payments on the page
    And the user sees text as a HMRC paid you child benefit date on the page



#Your PAYE income for the current tax year
  Scenario: User logins to activities page and should see user PAYE income for the current tax year
    Given User login to the activity Login Page
    And User is on activity start page
    And User should able to see Your recent account activity in govuk-heading-l
    And the user should sees text Your PAYE income for the current tax year on the page
    And the user sees PAYE income date on the page
    And the user should sees text Central Perk Coffee Ltd paid you PAYE income on the page
