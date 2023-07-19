@suite @CHB
Feature: Wrapper integrating with child benefit-frontend



  Scenario: User logins to Child Benefit Service and should see default GOV.UK header along with service name so user is reassured they have signed into Government service.
    Given I accesses the /view-proof-entitlement page with nino AB654321A
    Then User should see ChB title page Header contain logo text as GOV.UK in govuk-header__logotype-text
    Then User should see ChB title page Header contain service name as Personal tax account in govuk-header__content

  Scenario: The Phase banner if it is shown should only be positioned at the bottom of the page directly above the footer and feedback link should be redirect to 'Send your feedback' Page
    Given I accesses the /view-proof-entitlement page with nino AB654321A
    Then default content of phase status should be BETA
    Then User should able to see feedback link directly above the footer
    When User click on feedback link
    Then it should redirect to Send your feedback page
    Then Verify redirected URL should contains service name as your-details

  Scenario: Services should be able to configure the URL of Accessibility statement link
    Given I accesses the /view-proof-entitlement page with nino AB654321A
    Then User should see Accessibility statement link in the footer
    When User click on 'Accessibility statement' link
    Then Verify redirected URL should contains service name as your-details


  Scenario: User logins to Chocs web application and should see links in the footer
    Given I accesses the /view-proof-entitlement page with nino AB654321A
    Then User should see Cookies, Accessibility statement, Privacy policy, Terms and conditions, Help using GOV.UK, Contact and Rhestr o Wasanaethau Cymraeg links in the footer


  Scenario: User logins to Chocs web application and should see Is this page not working properly? link and this link should lead to a page that says 'Get help with a technical problem'.
    Given I accesses the /view-proof-entitlement page with nino AB654321A
    Then User should see Is this page not working properly? (opens in new tab) directly above the footer
    When User click on Is this page not working properly link
    Then User should redirect to Get help with a technical problem page
    Then Verify redirected URL should contains service name as your-details

  Scenario: User should be able to see the content in Welsh language
    Given I accesses the /view-proof-entitlement page with nino AB654321A
    When the user clicks on 'Cymraeg' welesh language link of single-customer-account/your-details
    Then the user sees services relevant content in welsh language
    When the user clicks on 'English' language link of single-customer-account/your-details
    And the user sees services relevant content in English language

  Scenario: User logins to Chocs web application should see the cookies banner and able to close it
    Given I accesses the /view-proof-entitlement page with nino AB654321A
    Then User should see cookies banner
    Then User should able to close it




