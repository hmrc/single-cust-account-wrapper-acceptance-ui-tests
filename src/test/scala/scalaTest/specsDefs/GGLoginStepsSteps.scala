/*
 * Copyright 2025 HM Revenue & Customs
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

package scalaTest.specsDefs

import uk.gov.hmrc.test.ui.pages.*

object GGLoginStepsSteps {

  // ^User login to the GG Login Page$
  def givenUserLoginToTheGGLoginPage(): Unit = {
    GGLoginPage.navigateToAuthLoginStub()
        GGLoginPage.enterRedirectURL()
        GGLoginPage.selectConfidenceLevel()
        GGLoginPage.enterNino()
        GGLoginPage.selectSAEnrolment()
        GGLoginPage.clickSubmitButton()
  }

  // ^User login to the GG Login Page Without SA enrollment$
  def givenUserLoginToTheGGLoginPageWithoutSAEnrollment(): Unit = {
    GGLoginPage.navigateToAuthLoginStub()
        GGLoginPage.enterRedirectURL()
        GGLoginPage.selectConfidenceLevel()
        GGLoginPage.enterNino()
        GGLoginPage.clickSubmitButton()
  }

  // ^User login to the GG Login Page with PTA enrolment$
  def givenUserLoginToTheGGLoginPageWithPTAEnrolment(): Unit = {
    GGLoginPage.navigateToAuthLoginStub()
        GGLoginPage.enterRedirectURL()
        GGLoginPage.selectConfidenceLevel()
        GGLoginPage.enterNino()
        GGLoginPage.selectPTAEnrolment()
        GGLoginPage.clickSubmitButton()
  }

  // ^User login to the Chocs GG Login Page$
  def givenUserLoginToTheChocsGGLoginPage(): Unit = {
    GGChocsLoginPage.navigateToAuthLoginStub()
        GGChocsLoginPage.enterRedirectURL()
        GGChocsLoginPage.selectConfidenceLevel()
        GGChocsLoginPage.enterNino()
        GGChocsLoginPage.selectPTAEnrolment()
        GGChocsLoginPage.selectSAEnrolment()
        GGChocsLoginPage.clickSubmitButton()
  }

  // ^User login to the Chocs GG Login Page Without SA enrollment$
  def givenUserLoginToTheChocsGGLoginPageWithoutSAEnrollment(): Unit = {
    GGChocsLoginPage.navigateToAuthLoginStub()
        GGChocsLoginPage.enterRedirectURL()
        GGChocsLoginPage.selectConfidenceLevel()
        GGChocsLoginPage.enterNino()
        GGChocsLoginPage.selectPTAEnrolment()
        GGChocsLoginPage.clickSubmitButton()
  }

  // ^User login to the Chocs GG Login Page with PTA enrolment$
  def givenUserLoginToTheChocsGGLoginPageWithPTAEnrolment(): Unit = {
    GGChocsLoginPage.navigateToAuthLoginStub()
        GGChocsLoginPage.enterRedirectURL()
        GGChocsLoginPage.selectConfidenceLevel()
        GGChocsLoginPage.enterNino()
        GGChocsLoginPage.selectPTAEnrolment()
        GGChocsLoginPage.clickSubmitButton()
  }

  // ^User login to the actions GG Login Page with nino (.*)$
  def givenUserLoginToTheActionsGGLoginPageWithNinoX(ninoNumber: String): Unit = {
    GGChocsLoginPage.navigateToAuthLoginStub()
        GGChocsLoginPage.enterRedirectActionURL()
        GGChocsLoginPage.selectConfidenceLevel()
        GGChocsLoginPage.enterNino(ninoNumber)
        GGChocsLoginPage.selectPTAEnrolment()
        GGChocsLoginPage.clickSubmitButton()
  }

  // ^User login to the NINO GG Login Page$
  def givenUserLoginToTheNINOGGLoginPage(): Unit = {
    GGNINOLoginPage.navigateToAuthLoginStub()
        GGNINOLoginPage.enterRedirectURL()
        GGNINOLoginPage.selectConfidenceLevel()
        GGNINOLoginPage.enterNino()
        GGNINOLoginPage.selectSAEnrolment()
        GGNINOLoginPage.clickSubmitButton()
  }

  // ^User login to the NINO GG Login Page Without SA enrollment$
  def givenUserLoginToTheNINOGGLoginPageWithoutSAEnrollment(): Unit = {
    GGNINOLoginPage.navigateToAuthLoginStub()
        GGNINOLoginPage.enterRedirectURL()
        GGNINOLoginPage.selectConfidenceLevel()
        GGNINOLoginPage.enterNino()
        GGNINOLoginPage.clickSubmitButton()
  }

  // ^User login to the NINO GG Login Page with PTA enrolment$
  def givenUserLoginToTheNINOGGLoginPageWithPTAEnrolment(): Unit = {
    GGNINOLoginPage.navigateToAuthLoginStub()
        GGNINOLoginPage.enterRedirectURL()
        GGNINOLoginPage.selectConfidenceLevel()
        GGNINOLoginPage.enterNino()
        GGNINOLoginPage.selectPTAEnrolment()
        GGNINOLoginPage.clickSubmitButton()
  }

  // ^I accesses the (.*) page with nino (.*)$
  def givenIAccessesTheXPageWithNinoX(url: String, nino: String): Unit = {
    url match {
          case "/actions" =>
            GGChildBenefitLogin.navigateToServiceUrl("actions", url)
            GGChildBenefitLogin.setConfidenceLevel()
            GGChildBenefitLogin.enterNINO(nino)
            GGChildBenefitLogin.clickSubmitButton()
          case "child-benefit" =>
            GGChildBenefitLogin.navigateToBaseUrl(url)
            GGChildBenefitLogin.setConfidenceLevel()
            GGChildBenefitLogin.enterNINO(nino)
            GGChildBenefitLogin.clickSubmitButton()
          case "/service-down" =>
            GGChildBenefitLogin.navigateToServiceUrl("child-benefit", url)
            GGChildBenefitLogin.setConfidenceLevel()
          case _ =>
            GGChildBenefitLogin.navigateToServiceUrl("child-benefit", url)
            GGChildBenefitLogin.setConfidenceLevel()
            GGChildBenefitLogin.enterNINO(nino)
            GGChildBenefitLogin.clickSubmitButton()
        }
  }

  // ^User login to the activity Login Page$
  def givenUserLoginToTheActivityLoginPage(): Unit = {
    GGLoginPage.navigateToAuthLoginStub()
        GGLoginPage.enterRedirectActivityURL()
        GGLoginPage.selectConfidenceLevel()
        GGLoginPage.enterNino()
        GGLoginPage.selectSAEnrolment()
        GGLoginPage.clickSubmitButton()
  }

}
