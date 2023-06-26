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

package uk.gov.hmrc.test.ui.utils.BrowserPackage

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import uk.gov.hmrc.webdriver.SingletonDriver

object Driver extends Driver

class Driver {
  val webDriver: WebDriver =
    (sys.props.get("environment").map(_.toLowerCase), sys.props.get("browser").map(_.toLowerCase)) match {
      case (Some("local"), Some("chrome")) =>
        val chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*")
        SingletonDriver.getInstance(Some(chromeOptions))
      case (Some("qa"), Some("chrome")) =>
        val chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*")
        SingletonDriver.getInstance(Some(chromeOptions))
      case _                               => SingletonDriver.getInstance()
    }
  //val webDriver: WebDriver = SingletonDriver.getInstance()

  sys addShutdownHook {
    SingletonDriver.closeInstance()
  }

}

