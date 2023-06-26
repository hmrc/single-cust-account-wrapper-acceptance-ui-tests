@suite
Feature: Claim your tax refund link


  Scenario: User logins to Actions Capabilities page and should see Claim your tax refund link
    Given User login to the actions GG Login Page with nino AA999999A
    Then User sees Things for you to do
    Then User sees Claim your tax refund
    Then User sees Things for you to do
    Then User sees You paid too much tax in the 2022 to 2023 tax year. HMRC owes you a £84.23 refund






