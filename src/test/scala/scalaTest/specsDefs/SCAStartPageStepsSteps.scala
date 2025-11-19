/*
 * Copyright 2025 HM Revenue & Customs
 *
 */

package scalaTest.specsDefs

import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.cucumber.stepdefs.BaseStepDef
import uk.gov.hmrc.test.ui.pages.SCAStartPage

object SCAStartPageStepsSteps extends BaseStepDef{

  // User is on SCA start page$
  def thenUserIsOnSCAStartPage(): Unit = {
    assert(SCAStartPage.verifySCAStartPage())
  }

  // User should see (.*) title page Header contain logo text as (.*) in (.*)$
  def thenUserShouldSeeXTitlePageHeaderContainLogoTextAsXInX(Servicename: String, value: String, locator: String): Unit = {
    (Servicename, SCAStartPage.assertContent(By.xpath("//*[@class='" + locator + "']"), value))
  }

  // ^User sees (.*)$
  def thenUserSeesX(message: String): Unit = {
    assert(SCAStartPage.confirmActionsResult(message));
  }

  // User should see (.*) title page Header contain service name as (.*) in (.*)$
  def thenUserShouldSeeXTitlePageHeaderContainServiceNameAsXInX(Servicename: String, value: String, locator: String): Unit = {
    (Servicename, SCAStartPage.assertContent(By.xpath("//*[@class='" + locator + "']"), value))
  }

  // User should see SCA title page footer contain (.*) in (.*)$
  def thenUserShouldSeeSCATitlePageFooterContainXInX(value: String, locator: String): Unit = {
    SCAStartPage.assertContent(By.xpath("//*[@class='" + locator + "']"), value)
  }

  // User should see SCA user name as (.*)$
  def thenUserShouldSeeSCAUserNameAsX(name: String): Unit = {
    assert(SCAStartPage.searchResults(name))
  }

  // User click (.*) on SCA landing page menu by (.*) (.*)$
  def whenUserClickXOnSCALandingPageMenuByXX(text: String, identifier: String, locator: String): Unit = {
    identifier match {
            case "id" => SCAStartPage.clickOn(By.id(locator))
            case _ => throw new RuntimeException("Type of element identifier not found")
          }
  }

  // User should see following services on home page menu (.*), (.*) and (.*)$
  def thenUserShouldSeeFollowingServicesOnHomePageMenu(TaxesAndBenefits: String, Messages: String, YourDetails: String): Unit = {
    assert(SCAStartPage.SCAMenuResult(TaxesAndBenefits, Messages, YourDetails))
  }

  // User should see following tiles on the page (.*), (.*) and (.*)$
  def thenUserShouldSeeFollowingTilesOnThePageX(PAYE: String, SA: String, StatePension: String): Unit = {
    assert(SCAStartPage.searchResult(PAYE, SA, StatePension))
  }

  // User click 'Complete your tax return' link under Self Assessment tile$
  def whenUserClickCompleteYourTaxReturnLinkUnderSelfAssessmentTile(): Unit = {
    SCAStartPage.clickOnTaxReturn()
  }

  // The user can see their tax details under (.*) in (.*)$
  def thenTheUserCanSeeTheirTaxDetailsUnderXInX(value: String, locator: String): Unit = {
    SCAStartPage.assertContent(By.xpath("//*[@class='" + locator + "']"), value)
  }

  // User should see following links (.*) and (.*) under State Pension tile$
  def thenUserShouldSeeFollowingLinksXAndXUnderStatePensionTile(statePensionLink: String, niLink: String): Unit = {
    assert(SCAStartPage.searchNISP(statePensionLink, niLink))
  }

  // User selects 'Check your State Pension summary' link in State Pension tile$
  def whenUserSelectsCheckYourStatePensionSummaryLinkInStatePensionTile(): Unit = {
    SCAStartPage.clickOnStatePensionSummary()
  }

  // System directs the user to State Pension summary page$""")(() =>
  def systemDirectsUserToStatePensionSummaryPage(): Unit = {
    assert(SCAStartPage.verifyStatePensionPageURL())
  }

  // ^User see (.*) in (.*)$
  def thenSystemDirectsTheUserToStatePensionSummaryPage(): Unit = {
    assert(SCAStartPage.verifyStatePensionPageURL())
  }

  def UserSeeXInX(value: String, locator: String): Unit = {
    SCAStartPage.assertContent(By.xpath("//*[@class='" + locator + "']"), value)
  }

  // The user should be able to return to 'Your taxes and benefits' page$
  def userShouldReturnToYourTaxesAndBenefitPage(): Unit = {
    SCAStartPage.returnToPreviousPage()
  }

  // User selects 'Check your National Insurance record' link in State Pension tile$
  def userSelectsCheckYourNationalInsuranceRecordLinkInStatePensionTile(): Unit = {
    SCAStartPage.clickOnNIRecord()
  }

  // System directs the user to National Insurance record page$""")(() =>
    def systemDirectsUserToNationInsuranceRecordPage(): Unit = {
      assert(SCAStartPage.verifyNIRecordPageURL())
    }

  // User should see CHOCS title page Header contain service name as (.*) in (.*)$
  def thenSystemDirectsTheUserToNationalInsuranceRecordPage(chocsServiceName: String, locator: String): Unit = {
      SCAStartPage.assertContent(By.xpath("//*[@class='" + locator + "']"), chocsServiceName)
  }

  // The user can see their messages under messages home page (.*)$
  def thenTheUserCanSeeTheirMessagesUnderMessagesHomePageX(Message: String): Unit = {
    assert(SCAStartPage.checkMessage(Message))
  }

  // User click on a Message$
  def whenUserClickOnAMessage(): Unit = {
    SCAStartPage.clickOnMessage()
  }

  // More information related to that message can be seen under message focus page (.*)$
  def thenMoreInformationRelatedToThatMessageCanBeSeenUnderMessageFocusPageX(Message: String): Unit = {
    SCAStartPage.assertContent(By.xpath("//*[(text()='" + Message + "')]"), Message)
  }

  // The user should be able to return to previous page$
  def thenTheUserShouldBeAbleToReturnToPreviousPage(): Unit = {
    SCAStartPage.clickOnBackButton()
  }

  // User should see if there is a link present on homepage to report Technical Problems (.*)$
  def thenUserShouldSeeIfThereIsALinkPresentOnHomepageToReportTechnicalProblemsX(technicalProblemsLink: String): Unit = {
    SCAStartPage.assertContent(
            By.xpath("//*[contains(text(),'" + technicalProblemsLink + "')]"),
            technicalProblemsLink
          )
  }

  // User click on new service feedback link$
  def whenUserClickOnNewServiceFeedbackLink(): Unit = {
    SCAStartPage.clickOnFeedback()
  }

  // User should see feedback page contain text as (.*)$
  def thenUserShouldSeeFeedbackPageContainTextAsX(feedbackPageText: String): Unit = {
    SCAStartPage.assertContent(By.xpath("//*[(text()='" + feedbackPageText + "')]"), feedbackPageText)
  }

  // User should return back to SCA home page$
  def userShouldReturnBackToSCA(): Unit = {
    SCAStartPage.returnToPreviousPage()
  }

  // User should get re-directed to customer feedback page$
  def userShouldGetDirectedToFeedback(): Unit = {
   assert(SCAStartPage.verifyFeedbackPageURL())
  }

  // User should see customer feedback page contain text as (.*)$
  def userShouldSeeCustomerFeedbackPage(feedbackPageText: String): Unit ={
    SCAStartPage.assertContent(By.xpath("//*[(text()='" + feedbackPageText + "')]"), feedbackPageText)
  }

  // User should see (.*) button$
  def thenUserShouldSeeXButton(SignOutLink: String): Unit = {
    SCAStartPage.assertContent(By.xpath("//*[contains(text(),'Sign out')]"),
            SignOutLink)
  }

  // User clicks on Sign out button
  def thenUserClicksOnSignOutButton(): Unit = {
    SCAStartPage.clickOnSignOut()
  }

}
