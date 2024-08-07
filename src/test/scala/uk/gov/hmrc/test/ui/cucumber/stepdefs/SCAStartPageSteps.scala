/*
 * Copyright 2024 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.pages.SCAStartPage

class SCAStartPageSteps extends BaseStepDef {

  Then("""User is on SCA start page$""") { () =>
    assert(SCAStartPage.verifySCAStartPage())
  }

  Then("""User should see (.*) title page Header contain logo text as (.*) in (.*)$""") {
    (Servicename: String, value: String, locator: String) =>
      (Servicename, SCAStartPage.assertContent(By.xpath("//*[@class='" + locator + "']"), value))
  }

  Then("""^User sees (.*)$""") { (message: String) =>
    assert(SCAStartPage.confirmActionsResult(message));
  }

  Then("""User should see (.*) title page Header contain service name as (.*) in (.*)$""") {
    (Servicename: String, value: String, locator: String) =>
      (Servicename, SCAStartPage.assertContent(By.xpath("//*[@class='" + locator + "']"), value))
  }

  Then("""User should see SCA title page footer contain (.*) in (.*)$""") { (value: String, locator: String) =>
    SCAStartPage.assertContent(By.xpath("//*[@class='" + locator + "']"), value)
  }

  Then("""User should see SCA user name as (.*)$""") { (name: String) =>
    assert(SCAStartPage.searchResults(name))
  }

  When("""User click (.*) on SCA landing page menu by (.*) (.*)$""") {
    (text: String, identifier: String, locator: String) =>
      identifier match {
        case "id" => SCAStartPage.clickOn(By.id(locator))
        case _ => throw new RuntimeException("Type of element identifier not found")
      }
  }

  Then("""User should see following services on home page menu (.*), (.*) and (.*)$""") {
    (TaxesAndBenefits: String, Messages: String, YourDetails: String) =>
      assert(SCAStartPage.SCAMenuResult(TaxesAndBenefits, Messages, YourDetails))
  }

  Then("""User should see following tiles on the page (.*), (.*) and (.*)$""") {
    (PAYE: String, SA: String, StatePension: String) =>
      assert(SCAStartPage.searchResult(PAYE, SA, StatePension))
  }

  When("""User click 'Complete your tax return' link under Self Assessment tile$""") {
    SCAStartPage.clickOnTaxReturn()
  }

  Then("""The user can see their tax details under (.*) in (.*)$""") { (value: String, locator: String) =>
    SCAStartPage.assertContent(By.xpath("//*[@class='" + locator + "']"), value)
  }

  Then("""User should see following links (.*) and (.*) under State Pension tile$""") {
    (statePensionLink: String, niLink: String) =>
      assert(SCAStartPage.searchNISP(statePensionLink, niLink))
  }

  When("""User selects 'Check your State Pension summary' link in State Pension tile$""") {
    SCAStartPage.clickOnStatePensionSummary()
  }

  Then("""System directs the user to State Pension summary page$""")(() =>
    assert(SCAStartPage.verifyStatePensionPageURL())
  )

  Then("""User see (.*) in (.*)$""") { (value: String, locator: String) =>
    SCAStartPage.assertContent(By.xpath("//*[@class='" + locator + "']"), value)
  }

  Then("""The user should be able to return to 'Your taxes and benefits' page$""")(SCAStartPage.returnToPreviousPage())

  When("""User selects 'Check your National Insurance record' link in State Pension tile$""") {
    SCAStartPage.clickOnNIRecord()
  }

  Then("""System directs the user to National Insurance record page$""")(() =>
    assert(SCAStartPage.verifyNIRecordPageURL())
  )

  Then("""User should see CHOCS title page Header contain service name as (.*) in (.*)$""") {
    (chocsServiceName: String, locator: String) =>
      SCAStartPage.assertContent(By.xpath("//*[@class='" + locator + "']"), chocsServiceName)
  }

  Then("""The user can see their messages under messages home page (.*)$""") { (Message: String) =>
    assert(SCAStartPage.checkMessage(Message))
  }

  When("""User click on a Message$""") {
    SCAStartPage.clickOnMessage()
  }

  Then("""More information related to that message can be seen under message focus page (.*)$""") { (Message: String) =>
    SCAStartPage.assertContent(By.xpath("//*[(text()='" + Message + "')]"), Message)
  }

  Then("""The user should be able to return to previous page$""") {
    SCAStartPage.clickOnBackButton()
  }

  Then("""User should see if there is a link present on homepage to report Technical Problems (.*)$""") {
    (technicalProblemsLink: String) =>
      SCAStartPage.assertContent(
        By.xpath("//*[contains(text(),'" + technicalProblemsLink + "')]"),
        technicalProblemsLink
      )
  }

  When("""User click on new service feedback link$""") {
    SCAStartPage.clickOnFeedback()
  }

  Then("""User should see feedback page contain text as (.*)$""") { (feedbackPageText: String) =>
    SCAStartPage.assertContent(By.xpath("//*[(text()='" + feedbackPageText + "')]"), feedbackPageText)
  }

  Then("""User should return back to SCA home page$""")(SCAStartPage.returnToPreviousPage())

  Then("""User should get re-directed to customer feedback page$""")(() => assert(SCAStartPage.verifyFeedbackPageURL()))

  Then("""User should see customer feedback page contain text as (.*)$""") { (feedbackPageText: String) =>
    SCAStartPage.assertContent(By.xpath("//*[(text()='" + feedbackPageText + "')]"), feedbackPageText)
  }

  Then("""User should see (.*) button$""") {
    (SignOutLink: String) =>
      SCAStartPage.assertContent(By.xpath("//*[contains(text(),'Sign out')]"),
        SignOutLink)

  }
  Then("""User clicks on Sign out button""") { () =>
    SCAStartPage.clickOnSignOut()
  }
}