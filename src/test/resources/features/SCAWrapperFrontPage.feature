@suite
Feature: Wrapper integrating with sca-frontend

  Scenario: User logins to SCA web application and should see default GOV.UK header along with service name so user is reassured they have signed into Government service.
    Given User login to the GG Login Page
    And User is on SCA start page
    Then User should see SCA title page Header contain logo text as GOV.UK in govuk-header__logotype-text
    Then User should see SCA title page Header contain service name as Single Customer Account in govuk-header__content

  Scenario: User logins to SCA web application and BTA menu only shown based on the SA enrolment rule.
    Given User login to the GG Login Page
    And User is on SCA start page
    When SA enrolment is applied
    Then User should see Business tax account menu option
  @wip
  Scenario: User logins to SCA web application and should see following menu items.
    Given User login to the GG Login Page Without SA enrollment
    Then User should see following option in menu Account home, Messages, Check progress, Profile and settings and Sign out
    Then User should also see Account home icon besides account home menu option
    Then User should not see Business tax account menu option

  Scenario: The Phase banner if it is shown should only be positioned at the bottom of the page directly above the footer and feedback link should be redirect to 'Send your feedback' Page
    Given User login to the GG Login Page
    Then default content of phase status should be ALPHA
    Then User should able to see feedback link directly above the footer
    When User click on feedback link
    Then it should redirect to Send your feedback page
    Then Verify redirected URL should contains service name as single-customer-account

  Scenario: Services should be able to configure the URL of Accessibility statement link
    Given User login to the GG Login Page
    Then User should see Accessibility statement link in the footer
    When User click on 'Accessibility statement' link
    Then Verify redirected URL should contains service name as single-customer-account

  Scenario: User logins to SCA web application and should see links in the footer
    Given User login to the GG Login Page
    Then User should see Cookies, Accessibility statement, Privacy policy, Terms and conditions, Help using GOV.UK, Contact and Rhestr o Wasanaethau Cymraeg links in the footer

  Scenario: User logins to SCA web application and should see Is this page not working properly? link and this link should lead to a page that says 'Get help with a technical problem'.
    Given User login to the GG Login Page
    Then User should see Is this page not working properly? (opens in new tab) directly above the footer
    When User click on Is this page not working properly link
    Then User should redirect to Get help with a technical problem page
    Then Verify redirected URL should contains service name as single-customer-account

  Scenario: User should be able to see the content in Welsh language
    Given User login to the GG Login Page
    When the user clicks on 'Cymraeg' welesh language link of single-customer-account
    Then the user sees relevant content in welsh language
    And the user can not click language 'Cymraeg' link
    When the user clicks on 'English' language link of single-customer-account
    Then the user can not click language 'English' link
    And the user sees relevant content in English language

  Scenario: User logins to SCA web application should see the cookies banner and able to close it
    And User is on SCA start page
    Then User should see cookies banner
    Then User should able to close it

  Scenario: User login with PTA enrolment and then verify all the menu links should redirecting to desired page
    Given User login to the GG Login Page with PTA enrolment
    When the user clicks on Account home menu
    Then user should go through tax letter journey and redirect to Account home page
    When the user clicks on Messages menu
    Then user should redirect to Messages page
    When the user clicks on Check progress menu
    When the user clicks on Profile and settings menu
    Then user should redirect to Profile and settings page
    When the user clicks on Sign out menu
    Then user should redirect to Give feedback page

  Scenario: Check the messages icon displays correctly
    Given The message collection is dropped from mongo database
    And User login to the GG Login Page with PTA enrolment
    And A message is posted to the messages API in the local environment
    Then the user should see 1 as the number of messages


#    Time out - Manual check - Check Java script loaded on the page
#    Attorney Banner
#    Sign out
#    SCA start page - No menu bar,

