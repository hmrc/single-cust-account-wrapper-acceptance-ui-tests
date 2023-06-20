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

class ActivitiesPageSteps extends ScalaDsl with EN with Matchers with WebBrowser {

  And("""User is on activity start page$""")(() => assert(SCAStartPage.verifySCAStartPage()))

  Then("""User should see (.*) in (.*)$""") { (value: String, locator: String) =>
    SCAStartPage.assertContent(By.xpath("//*[@class='" + locator + "']"), value)
  }

  Then("""User should see (.*) text on activity page$""") { (value: String) =>
    SCAStartPage.assertContent(By.xpath("//*[contains(text(),'" + value + "')]"), value)
  }

  And("""^the user sees text '(.*)' on the page$"""){(value: String) =>
    SCAStartPage.assertContent(By.xpath("//*[contains(text(),'" + value + "')]"), value)
  }

  Then("""User should not see (.*) text on activity page$""") { (value: String) =>
    assertTrue(webDriver.findElements(By.xpath("//*[contains(text(),'" + value + "')]")).isEmpty)
  }
}
