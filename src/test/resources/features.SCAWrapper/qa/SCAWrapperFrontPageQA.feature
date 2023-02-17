@suite
Feature: Wrapper integrating with sca-frontend


  Scenario: User logins to SCA web application and should see links in the footer

    Given User login to the GG Login Page with PTA enrolment
    When User clicks on Cookies footer link
    Then user should redirect to Cookie settings page
    When User clicks on Privacy policy footer link
    And user should redirect to HMRC Privacy Notice page
    When User clicks on Terms and conditions footer link
    Then user should redirect to Terms and conditions page
    When User clicks on Help using GOV.UK footer link
    Then user should redirect to Help using GOV.UK page
    When User clicks on Contact footer link
    Then user should redirect to Contact HM Revenue & Customs page
    When User clicks on Rhestr o Wasanaethau Cymraeg footer link
    Then user should redirect to Defnyddio page