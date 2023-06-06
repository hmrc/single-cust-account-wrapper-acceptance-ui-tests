
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

