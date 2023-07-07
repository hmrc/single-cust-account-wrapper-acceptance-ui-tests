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
import org.junit.Assert.assertTrue
import org.openqa.selenium.By
import org.scalatest.matchers.must.Matchers
import org.scalatestplus.selenium._
import uk.gov.hmrc.test.ui.pages.SCAStartPage
import uk.gov.hmrc.test.ui.utils.BrowserPackage.Driver.webDriver

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ActivitiesPageSteps extends ScalaDsl with EN with Matchers with WebBrowser {

  And("""User is on activity start page$""")(() => assert(SCAStartPage.verifySCAStartPage()))

  Then("""User should able to see (.*) in (.*)$""") { (value: String, locator: String) =>
    SCAStartPage.assertContent(By.xpath("//*[@class='" + locator + "']"), value)
  }

  Then("""^User should see test text on activity page$""") { () =>
    val date = LocalDate.now.minusMonths(2).minusDays(1)
    val formatter = DateTimeFormatter.ofPattern("d LLLL yyyy")
    val formattedString = date.format(formatter)
    System.out.print(formattedString)
    SCAStartPage.assertContent(By.xpath("(//div[@class='govuk-summary-list__row'][dd/a[contains(text(), 'Your tax calculation for the 2022-2023 is now available')]]/dt/strong[contains(text(), '" + formattedString + "')])[1]"), formattedString)

  }

  Then("""^the user sees PAYE income date on the page$""") { () =>
    val date = LocalDate.now.minusMonths(2).minusDays(1)
    val formatter = DateTimeFormatter.ofPattern("d LLLL yyyy")
    val formattedString = date.format(formatter)
    System.out.print(formattedString)
    SCAStartPage.assertContent(By.xpath("//div[@class='govuk-summary-list__row'][contains(., \"Central Perk Coffee Ltd paid you PAYE income\")]/descendant::dt/strong[contains(text(), '" + formattedString + "')]"), formattedString)


}


  And("""the user sees text latest tax code change date on the page""") { () =>
    val date = LocalDate.now.minusMonths(2).minusDays(1)
    val formatter = DateTimeFormatter.ofPattern("d LLLL yyyy")
    val formattedString = date.format(formatter)
    SCAStartPage.assertContent(By.xpath("//div[@class='govuk-summary-list__row'][descendant::dt/strong[normalize-space(text())='" + formattedString + "']][1]/dt/strong"), formattedString)

  }

  And("""^the user sees text as a (.*) date on the page$""") { (value: String) =>

    value match {
      case "Your tax code has changed - 7" =>
        val taxcode7date = LocalDate.now
        val formatter = DateTimeFormatter.ofPattern("d LLLL yyyy")
        val formattedString = taxcode7date.format(formatter)
        System.out.print("7" + formattedString)
        SCAStartPage.assertContent(By.xpath("//div[@class='govuk-summary-list__row'][descendant::dt/strong[normalize-space(text())='" + formattedString + "']][1]/dt/strong"), formattedString)

      case "Your tax code has changed - 6" =>
        val taxcode6date = LocalDate.now.withMonth(4).withDayOfMonth(7)
        val formatter = DateTimeFormatter.ofPattern("d LLLL yyyy")
        val formattedString = taxcode6date.format(formatter)
        System.out.print("6" + formattedString)
        SCAStartPage.assertContent(By.xpath("//div[@class='govuk-summary-list__row'][descendant::dt/strong[normalize-space(text())='" + formattedString + "']][1]/dt/strong"), formattedString)

      case "Your tax code has changed - 5" =>
        val taxcode6date = LocalDate.now.withMonth(4).withDayOfMonth(6)
        val formatter = DateTimeFormatter.ofPattern("d LLLL yyyy")
        val formattedString = taxcode6date.format(formatter)
        System.out.print("6" + formattedString)
        SCAStartPage.assertContent(By.xpath("//div[@class='govuk-summary-list__row'][descendant::dt/strong[normalize-space(text())='" + formattedString + "']][1]/dt/strong"), formattedString)


      case "Your tax code has changed - 4" =>
        val taxcode6date = LocalDate.now.withMonth(4).withDayOfMonth(5)
        val formatter = DateTimeFormatter.ofPattern("d LLLL yyyy")
        val formattedString = taxcode6date.format(formatter)
        System.out.print("6" + formattedString)
        SCAStartPage.assertContent(By.xpath("//div[@class='govuk-summary-list__row'][descendant::dt/strong[normalize-space(text())='" + formattedString + "']][1]/dt/strong"), formattedString)


      case "Your tax code has changed - 3" =>
        val taxcode6date = LocalDate.now.minusMonths(3).plusDays(1)
        val formatter = DateTimeFormatter.ofPattern("d LLLL yyyy")
        val formattedString = taxcode6date.format(formatter)
        System.out.print("6" + formattedString)
        SCAStartPage.assertContent(By.xpath("//div[@class='govuk-summary-list__row'][descendant::dt/strong[normalize-space(text())='" + formattedString + "']][1]/dt/strong"), formattedString)


      case "Your tax code has changed - 2" =>
        val taxcode6date = LocalDate.now.minusMonths(2)
        val formatter = DateTimeFormatter.ofPattern("d LLLL yyyy")
        val formattedString = taxcode6date.format(formatter)
        System.out.print("6" + formattedString)
        SCAStartPage.assertContent(By.xpath("//div[@class='govuk-summary-list__row'][descendant::dt/strong[normalize-space(text())='" + formattedString + "']][1]/dt/strong"), formattedString)


      case "Your tax code has changed - 1" =>
        val taxcode6date = LocalDate.now.minusMonths(1).minusDays(1)
        val formatter = DateTimeFormatter.ofPattern("d LLLL yyyy")
        val formattedString = taxcode6date.format(formatter)
        System.out.print("6" + formattedString)
        SCAStartPage.assertContent(By.xpath("//div[@class='govuk-summary-list__row'][descendant::dt/strong[normalize-space(text())='" + formattedString + "']][1]/dt/strong"), formattedString)

      case "HMRC paid you child benefit" =>
        val childbenefitdate = LocalDate.now.minusMonths(1).minusDays(1)
        val formatter = DateTimeFormatter.ofPattern("d LLLL yyyy")
        val formattedString = childbenefitdate.format(formatter)
        SCAStartPage.assertContent(By.xpath("//div[@class='govuk-summary-list__row'][descendant::dt/strong[normalize-space(text())='" + formattedString + "']][1]/dt/strong"), formattedString)

        val childbenefitdate1 = LocalDate.now.minusMonths(2)
        val formattedString1 = childbenefitdate1.format(formatter)
        SCAStartPage.assertContent(By.xpath("//div[@class='govuk-summary-list__row'][descendant::dt/strong[normalize-space(text())='" + formattedString1 + "']][1]/dt/strong"), formattedString1)

        val childbenefitdate2 = LocalDate.now.withMonth(4).withDayOfMonth(6)
        val formattedString2 = childbenefitdate2.format(formatter)
        SCAStartPage.assertContent(By.xpath("//div[@class='govuk-summary-list__row'][descendant::dt/strong[normalize-space(text())='" + formattedString2 + "']][1]/dt/strong"), formattedString2)


        val childbenefitdate3 = LocalDate.now.withMonth(4).withDayOfMonth(5)
        val formattedString3 = childbenefitdate3.format(formatter)
        SCAStartPage.assertContent(By.xpath("//div[@class='govuk-summary-list__row'][descendant::dt/strong[normalize-space(text())='" + formattedString3 + "']][1]/dt/strong"), formattedString3)

        val childbenefitdate4 = LocalDate.now.minusMonths(3).plusDays(1)
        val formattedString4 = childbenefitdate4.format(formatter)
        SCAStartPage.assertContent(By.xpath("//div[@class='govuk-summary-list__row'][descendant::dt/strong[normalize-space(text())='" + formattedString4 + "']][1]/dt/strong"), formattedString4)


    }



  }

  And("""^the user sees text '(.*)' on the page$"""){(value: String) =>
    SCAStartPage.assertContent(By.xpath("//*[contains(text(),'" + value + "')]"), value)
  }


  And("""^the user should sees text (.*) on the page$""") { (value: String) =>
    SCAStartPage.assertContent(By.xpath("//*[contains(text(),'" + value + "')]"), value)
  }


  And("""^the user should sees latest tax code text (.*) on the page$""") { (value: String) =>
    SCAStartPage.assertContent(By.xpath("//*[contains(a/text(), '" + value + "')]"), value)
  }

  Then("""User should not see (.*) text on activity page$""") { (value: String) =>
    assertTrue(webDriver.findElements(By.xpath("//*[contains(text(),'" + value + "')]")).isEmpty)
  }
}
