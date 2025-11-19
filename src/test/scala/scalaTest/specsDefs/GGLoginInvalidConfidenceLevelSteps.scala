/*
 * Copyright 2025 HM Revenue & Customs
 *
 */

package scalaTest.specsDefs

import uk.gov.hmrc.test.ui.pages.{GGLoginPage, GGLoginPageInvalidConfidenceLevel}

object GGLoginInvalidConfidenceLevelSteps {

  // User login to the GGLogin Page$
  def givenUserLoginToTheGGLoginPage(): Unit = {
    GGLoginPage.navigateToAuthLoginStub()
        GGLoginPage.enterRedirectURL()
  }

  // ^Confidence level less is less than 200$
  def whenConfidenceLevelLessIsLessThan200(): Unit = {
    GGLoginPageInvalidConfidenceLevel.selectConfidenceLevel()
        GGLoginPage.enterNino()
        GGLoginPage.clickSubmitButton()
  }

  // ^User should see SCA home page with an error "([^"]*)"$
  def thenUserShouldSeeSCAHomePageWithAnError()(accessError: String): Unit = {
    assert(GGLoginPageInvalidConfidenceLevel.verifySCAStartPageAccessError(accessError))
  }

}
