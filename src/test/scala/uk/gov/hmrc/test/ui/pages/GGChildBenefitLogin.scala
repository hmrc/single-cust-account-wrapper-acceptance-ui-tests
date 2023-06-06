
package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.PagePaths.{FeedbackPagePaths, GGloginPagePaths, SCAStartPagePaths}
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.utils.BrowserPackage.StartUpTearDown

object GGChildBenefitLogin extends StartUpTearDown with GGloginPagePaths with SCAStartPagePaths with FeedbackPagePaths {


  def navigateToBaseUrl(url: String): Unit = {
    deleteCookies()
    driver.navigate().to(TestConfiguration.url(url))
  }

  def navigateToServiceUrl(url: String, serviceName: String): Unit = {
    deleteCookies()
    driver.navigate().to(TestConfiguration.url(url) + serviceName)
    driver.manage().window().maximize()
  }

  def deleteCookies(): Unit =
    driver.manage().deleteAllCookies()

  def setConfidenceLevel(): Unit =
    driver.findElement(By.id("confidenceLevel")).sendKeys("200")

  def setOrganisationAffinityGroup(): Unit =
    driver.findElement(By.id("affinityGroupSelect")).sendKeys("Organisation")

  def enterNINO(nino: String): Unit =
    nino match {
      case "invalidService" =>
      case _                => driver.findElement(By.id("nino")).sendKeys(nino)
    }

  def clickSubmitButton(): Unit =
    driver.findElement(By.id("submit")).click()


}
