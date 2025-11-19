/*
 * Copyright 2024 HM Revenue & Customs
 *
 */

package scalaTest.specs

import org.scalatest.*
import org.scalatest.concurrent.Eventually
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}

trait BaseSpec
    extends AnyFeatureSpec
    with GivenWhenThen
    with BeforeAndAfterEach
    with BeforeAndAfterAll
    with Matchers
    with Browser
    with Eventually
    with ScreenshotOnFailure {

  override def beforeAll(): Unit =
    startBrowser()

  override def afterAll(): Unit =
    quitBrowser()

}
