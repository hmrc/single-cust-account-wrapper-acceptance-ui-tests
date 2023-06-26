@suite
Feature: Wrapper integrating with child benefit-frontend


  Scenario: User logins to Chocs Service and should see default GOV.UK header along with service name so user is reassured they have signed into Government service.
    Given User login to the actions GG Login Page with nino AA999999A
    Then User should see Things for you to do
    Then User should see Claim your tax refund
    Then User should see Things for you to do
    Then User should see You paid too much tax in the 2022 to 2023 tax year.
    Then User should see HMRC owes you a £84.23 refund





