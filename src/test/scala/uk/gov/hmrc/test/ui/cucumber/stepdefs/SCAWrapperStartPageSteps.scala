/*
 * Copyright 2023 HM Revenue & Customs
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

import io.cucumber.scala.{EN, ScalaDsl}
import org.eclipse.jetty.websocket.common.message.MessageReader
import org.junit.Assert.assertTrue
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, NoSuchElementException}
import org.scalatest.matchers.must.Matchers
import org.scalatestplus.selenium._
import uk.gov.hmrc.test.ui.PagePaths.GGloginPagePaths
import uk.gov.hmrc.test.ui.pages.GGLoginPage.{AccountHomeIcon, banner}
import uk.gov.hmrc.test.ui.pages.SCAStartPage
import uk.gov.hmrc.test.ui.utils.BrowserPackage.Driver.webDriver

import java.time.Duration

class SCAWrapperStartPageSteps extends ScalaDsl with EN with Matchers with WebBrowser with GGloginPagePaths {

  When("""SA enrolment is applied""") { () =>
    print("SA enrollment is applied")
  }

  Then("""User should see (.*) menu option$""") { (BTA: String) =>
    assert(SCAStartPage.SCABTALink(BTA))
  }

  Then("""User should see following option in menu (.*), (.*), (.*), (.*) and (.*)$""") {
    (AccountHome: String, Messages: String, CheckProgress: String, ProfileAndSettings: String, SignOut: String) =>
      assert(SCAStartPage.WrapperSCAMenu(AccountHome, Messages, CheckProgress, ProfileAndSettings, SignOut))
  }

  Then("""User should also see (.*) icon besides account home menu option$""") { (value: String) =>
    SCAStartPage.assertContent(By.xpath(AccountHomeIcon), value)
  }

  Then("""default content of phase status should be (.*)$""") { (Message: String) =>
    SCAStartPage.assertContent(By.xpath(banner), Message)
  }
  Then("""User should able to see (.*) link directly above the footer$""") { (FeedbackLink: String) =>
    assert(SCAStartPage.FeedBackLink(FeedbackLink))
  }
  When("""User click on feedback link""") { () =>
    SCAStartPage.clickOnFeedback()
  }
  Then("""it should redirect to (.*) page$""") { (Feedbackpage: String) =>
    assert(SCAStartPage.FeedBackPage(Feedbackpage))
  }
  Then("""User should see (.*) directly above the footer$""") { (PageNotWorkingProperly: String) =>
    assert(SCAStartPage.PageNotWorkingProperlyLink(PageNotWorkingProperly))
  }
  When("""User click on Is this page not working properly link""") { () =>
    SCAStartPage.clickOnPageNotWorkingProperly()
  }
  Then("""User should redirect to (.*) page$""") { (PageNotWorkingProperly: String) =>
    SCAStartPage.moveToTab()
    assert(SCAStartPage.PageNotWorkingProperly(PageNotWorkingProperly))
  }
  Then("""Verify redirected URL should contains service name as single-customer-account""") { () =>
    SCAStartPage.VerifyServiceName()

  }
  Then("""User should see (.*) link in the footer$""") { (Accessibilitystatement: String) =>
    assert(SCAStartPage.AccessibilitystatementLink(Accessibilitystatement))

  }
  When("""User click on 'Accessibility statement' link""") { () =>
    SCAStartPage.clickOnAccessibilitystatementLink()
  }
  Then("""User should see (.*), (.*), (.*), (.*), (.*), (.*) and (.*) links in the footer$""") {
    (
      Cookies: String,
      AccessibilityStatement: String,
      PrivacyPolicy: String,
      TermsAndConditions: String,
      HelpUsingGOVUK: String,
      Contact: String,
      WelshLanguage: String
    ) =>
      SCAStartPage.WrapperSCAFooter(
        Cookies,
        AccessibilityStatement,
        PrivacyPolicy,
        TermsAndConditions,
        HelpUsingGOVUK,
        Contact,
        WelshLanguage
      )

  }

  And("""^the user sees relevant content in welsh language$""") { () =>
    val texts =
      List("Gwasanaeth")
    SCAStartPage.textContentVerify(texts)
  }

  When("""the user clicks on 'Cymraeg' welesh language link""") { () =>
    SCAStartPage.clickOnCymraeg()

  }
  When("""the user clicks on 'English' language link""") { () =>
    SCAStartPage.clickOnEnglish()

  }

  And("""the user sees relevant content in English language""") { () =>
    val texts = List("Single Customer Account")

    SCAStartPage.textContentVerify(texts)
  }

  And("""^the user can not click language '(.*)' link$""") { (linkName: String) =>
    intercept[NoSuchElementException] {
      linkName match {
        case "Cymraeg" =>
          assert(
            !webDriver
              .findElement(By.cssSelector("a[href*='/single-customer-account/hmrc-frontend/language/cy']"))
              .isEnabled,
            s"language $linkName is present on the page"
          )

        case "English" =>
          assert(
            !webDriver
              .findElement(By.cssSelector("a[href*='/single-customer-account/hmrc-frontend/language/en']"))
              .isEnabled,
            s"language $linkName is present on the page"
          )
      }
    }
  }

  When("""^the user clicks on (.*) menu$""") { linkName: String =>
    linkName match {
      case "Account home"         =>
        webDriver.findElement(By.partialLinkText(linkName)).click()
      case "Messages"             =>
        webDriver.findElement(By.partialLinkText(linkName)).click()
      case "Check progress"       =>
        webDriver.findElement(By.partialLinkText(linkName)).click()
      case "Profile and settings" =>
        webDriver.findElement(By.partialLinkText(linkName)).click()
      case "Sign out"             =>
        webDriver.findElement(By.partialLinkText(linkName)).click()

    }
  }

  When("""^User clicks on (.*) footer link$""") { linkName: String =>
    linkName match {
      case "Cookies"                      =>
        webDriver.findElement(By.partialLinkText(linkName)).click()
      case "Accessibility statement"      =>
        webDriver.findElement(By.partialLinkText(linkName)).click()
      case "Privacy policy"               =>
        webDriver.findElement(By.partialLinkText(linkName)).click()
      case "Terms and conditions"         =>
        webDriver.findElement(By.partialLinkText(linkName)).click()
      case "Help using GOV.UK"            =>
        webDriver.findElement(By.partialLinkText(linkName)).click()
      case "Contact"                      =>
        webDriver.findElement(By.partialLinkText(linkName)).click()
      case "Rhestr o Wasanaethau Cymraeg" =>
        webDriver.findElement(By.partialLinkText(linkName)).click()

    }
  }

  Then("""user should redirect to (.*) page$""") { (locator: String) =>
    webDriver.findElement(By.xpath("//*[contains(text(),'" + locator + "')]")).isDisplayed
    webDriver.navigate().back()
  }

  Then("""user should go through tax letter journey and redirect to Account home page""") { () =>
    val wait = new WebDriverWait(webDriver, Duration.ofSeconds(50))
   // webDriver.findElement(By.id("sps-opt-in-2")).click()
   // webDriver.findElement(By.id("submitEmailButton")).click()
  //  wait.until(ExpectedConditions.urlContains("/paperless/optout-confirmation?"))
   // webDriver.findElement(By.id("submitEmailButton")).click()
    wait.until(
      ExpectedConditions.or(
        ExpectedConditions.urlContains("/paperless/survey/optin-declined?"),
        ExpectedConditions.urlContains("/personal-account")
      )
    )
    webDriver.findElement(By.xpath("//*[contains(text(),'Account home')]")).isDisplayed
    webDriver.navigate().back()
  //  webDriver.navigate().back()
   // webDriver.navigate().back()
  }

  Then("""User should see cookies banner""") { () =>
    webDriver.findElement(By.xpath("//*[contains(text(),'Accept additional cookies')]")).isDisplayed

  }
  Then("""User should able to close it""") { () =>
    webDriver.findElement(By.xpath("//*[contains(text(),'Accept additional cookies')]")).click()
    webDriver.findElement(By.xpath("//*[contains(text(),'Hide cookies message')]")).click()
  }

  Then("""User should not see Business tax account menu option""") { () =>
    assertTrue(webDriver.findElements(By.xpath("//*[contains(text(),'Business tax account')]")).isEmpty)
  }


}
