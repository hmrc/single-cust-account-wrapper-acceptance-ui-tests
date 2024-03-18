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

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait}
import org.openqa.selenium.{By, WebDriver}
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import uk.gov.hmrc.test.ui.PagePaths.{ActionsPagePaths, FeedbackPagePaths, GGloginPagePaths, SCAStartPagePaths}
import uk.gov.hmrc.test.ui.pages.config.Configuration
import uk.gov.hmrc.test.ui.utils.HttpClient

import java.time.Duration

object SCAStartPage
  extends BasePage
    with GGloginPagePaths
    with ActionsPagePaths
    with SCAStartPagePaths
    with FeedbackPagePaths
    with HttpClient {
  def verifySCAStartPage(): Boolean =
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.urlMatches(Configuration.settings.APPROOT))

  def searchResults(name: String): Boolean =
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.id(accountName), name))

  def SCAMenuResult(TaxesAndBenefits: String, Messages: String, YourDetails: String): Boolean = {
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.id(TaxandBenefits), TaxesAndBenefits))
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.id(Msgs), Messages))
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.id(PersonalDetails), YourDetails))
  }

  def searchResult(PAYE: String, SA: String, StatePension: String): Boolean = {
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.id(PayAsYouEarn), PAYE))
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.id(selfAssesment), SA))
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.id(Pension), StatePension))
  }

  def searchNISP(statePensionLink: String, niLink: String): Boolean = {
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(statePensionURL), statePensionLink))
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(niURL), niLink))
  }

  def clickOnTaxReturn(): Unit = webDriver.findElement(By.linkText(taxReturnLink)).click()

  def clickOnStatePensionSummary(): Unit = webDriver.findElement(By.linkText(statePensionLink)).click()

  def verifyStatePensionPageURL(): Boolean =
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.urlMatches(Configuration.settings.STATEPENSION_PAGE))

  def clickOnNIRecord(): Unit = webDriver.findElement(By.linkText(niLink)).click()

  def verifyNIRecordPageURL(): Boolean =
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.urlMatches(Configuration.settings.NI_PAGE))

  def checkMessage(Message: String): Boolean =
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(scaMessage), Message))

  def clickOnMessage(): Unit = webDriver.findElement(By.partialLinkText(yourMessage)).click()

  def clickOnBackButton(): Unit = webDriver.findElement(By.className(backButton)).click()

  def clickOnFeedback(): Unit = webDriver.findElement(By.xpath(FeedbacklinkJenkins)).click()

  def returnToPreviousPage(): Unit = webDriver.navigate.back()

  def verifyFeedbackPageURL(): Boolean =
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.urlMatches(Configuration.settings.FEEDBACK_PAGE))

  def assertContent(id: By, expectedText: String) = webDriver.findElement(id).getText must be(expectedText)

  def clickOn(by: By): Unit =
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .until(ExpectedConditions.elementToBeClickable(by))
      .click()

  def clickById(id: String): Unit =
    clickOn(By.id(id))

  def SCABTALink(BTA: String): Boolean =
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(BusinessAccountLink), BTA))

  def WrapperSCAMenu(
                      AccountHome: String,
                      Messages: String,
                      CheckProgress: String,
                      ProfileAndSettings: String,
                      SignOut: String
                    ): Boolean = {
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(AccountHomeLink), AccountHome))
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(MessagesLink), Messages))
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(CheckProgressLink), CheckProgress))
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(ProfileAndSettingsLink), ProfileAndSettings))
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(SignOutLink), SignOut))

  }

  def confirmActionsResult(message: String): Boolean =
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(actionsResult), message))


  def FeedBackLink(FeedbackLink: String): Boolean =
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.className("govuk-phase-banner__text"), FeedbackLink))

  def FeedBackLinkJenkins(FeedbackLink: String): Boolean =
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(FeedbacklinkJenkins), FeedbackLink))

  def FeedBackPage(Feedbackpage: String): Boolean =
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(pageFeedback), Feedbackpage))

  def clickOnPageNotWorkingProperly(): Unit = webDriver.findElement(By.linkText(pageNotWorkingProperlyLink)).click()

  def PageNotWorkingProperlyLink(PageNotWorkingProperly: String): Boolean =
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(
        ExpectedConditions
          .textToBePresentInElementLocated(By.linkText(pageNotWorkingProperlyLink), PageNotWorkingProperly)
      )

  def PageNotWorkingProperly(PageNotWorkingProperly: String): Boolean =
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(
        ExpectedConditions.textToBePresentInElementLocated(By.xpath(pageNotWorkingProperly), PageNotWorkingProperly)
      )

  def moveToTab(): WebDriver = {

    import java.util
    val newTb = new util.ArrayList[String](webDriver.getWindowHandles)
    webDriver.switchTo.window(newTb.get(1))
    webDriver.switchTo.window(newTb.get(1))
  }

  def VerifyServiceName(Serivename: String): Unit = {
    val url = webDriver.getCurrentUrl
    assert(url.contains(Serivename))

  }

  def AccessibilitystatementLink(Accessibilitystatement: String): Boolean =
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(
        ExpectedConditions
          .textToBePresentInElementLocated(By.linkText(AccessibilitystatementLink), Accessibilitystatement)
      )

  def clickOnAccessibilitystatementLink(): Unit = webDriver.findElement(By.linkText(AccessibilitystatementLink)).click()

  def WrapperSCAFooter(
                        Cookies: String,
                        AccessibilityStatement: String,
                        PrivacyPolicy: String,
                        TermsAndConditions: String,
                        HelpUsingGOVUK: String,
                        Contact: String,
                        WelshLanguage: String
                      ): Boolean = {
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.linkText("Cookies"), Cookies))
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(
        ExpectedConditions
          .textToBePresentInElementLocated(By.linkText("Accessibility statement"), AccessibilityStatement)
      )
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.linkText("Privacy policy"), PrivacyPolicy))
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(
        ExpectedConditions.textToBePresentInElementLocated(By.linkText("Terms and conditions"), TermsAndConditions)
      )
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.linkText("Help using GOV.UK"), HelpUsingGOVUK))

    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(ExpectedConditions.textToBePresentInElementLocated(By.linkText("Contact"), Contact))
    new FluentWait[WebDriver](webDriver)
      .withTimeout(Duration.ofSeconds(Configuration.settings.PAGE_TIMEOUT_SECS))
      .ignoring(classOf[Nothing])
      .until(
        ExpectedConditions.textToBePresentInElementLocated(By.linkText("Rhestr o Wasanaethau Cymraeg"), WelshLanguage)
      )

  }


  def textContentVerify(txts: List[String]) =
    for (txt <- txts)
      assert(webDriver.getPageSource.contains(txt), s"\n'$txt' text was not found on the page")

  def clickOnCymraeg(Servicename: String): Unit = webDriver.findElement(By.xpath("//a[@href='/" + Servicename + "/hmrc-frontend/language/cy']")).click()

  def clickOnEnglish(Servicename: String): Unit =
    webDriver.findElement(By.xpath("//a[@href='/" + Servicename + "/hmrc-frontend/language/en']")).click()

}
