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

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import uk.gov.hmrc.test.ui.pages.{GGChildBenefitLogin, GGChocsLoginPage, GGLoginPage, GGNINOLoginPage}

class GGLoginSteps extends BaseStepDef {

  Given("""^User login to the GG Login Page$""") { () =>
    GGLoginPage.navigateToAuthLoginStub()
    GGLoginPage.enterRedirectURL()
    GGLoginPage.selectConfidenceLevel()
    GGLoginPage.enterNino()
    GGLoginPage.selectSAEnrolment()
    GGLoginPage.clickSubmitButton()
  }

  Given("""^User login to the GG Login Page Without SA enrollment$""") { () =>
    GGLoginPage.navigateToAuthLoginStub()
    GGLoginPage.enterRedirectURL()
    GGLoginPage.selectConfidenceLevel()
    GGLoginPage.enterNino()
    GGLoginPage.clickSubmitButton()
  }

  Given("""^User login to the GG Login Page with PTA enrolment$""") { () =>
    GGLoginPage.navigateToAuthLoginStub()
    GGLoginPage.enterRedirectURL()
    GGLoginPage.selectConfidenceLevel()
    GGLoginPage.enterNino()
    GGLoginPage.selectPTAEnrolment()
    GGLoginPage.clickSubmitButton()
  }

  Given("""^User login to the Chocs GG Login Page$""") { () =>
    GGChocsLoginPage.navigateToAuthLoginStub()
    GGChocsLoginPage.enterRedirectURL()
    GGChocsLoginPage.selectConfidenceLevel()
    GGChocsLoginPage.enterNino()
    GGChocsLoginPage.selectPTAEnrolment()
    GGChocsLoginPage.selectSAEnrolment()
    GGChocsLoginPage.clickSubmitButton()
  }

  Given("""^User login to the Chocs GG Login Page Without SA enrollment$""") { () =>
    GGChocsLoginPage.navigateToAuthLoginStub()
    GGChocsLoginPage.enterRedirectURL()
    GGChocsLoginPage.selectConfidenceLevel()
    GGChocsLoginPage.enterNino()
    GGChocsLoginPage.selectPTAEnrolment()
    GGChocsLoginPage.clickSubmitButton()
  }
  Given("""^User login to the Chocs GG Login Page with PTA enrolment$""") { () =>
    GGChocsLoginPage.navigateToAuthLoginStub()
    GGChocsLoginPage.enterRedirectURL()
    GGChocsLoginPage.selectConfidenceLevel()
    GGChocsLoginPage.enterNino()
    GGChocsLoginPage.selectPTAEnrolment()
    GGChocsLoginPage.clickSubmitButton()
  }


  Given("""^User login to the actions GG Login Page with nino (.*)$""") { (ninoNumber: String) =>
    GGChocsLoginPage.navigateToAuthLoginStub()
    GGChocsLoginPage.enterRedirectActionURL()
    GGChocsLoginPage.selectConfidenceLevel()
    GGChocsLoginPage.enterNino(ninoNumber)
    GGChocsLoginPage.selectPTAEnrolment()
    GGChocsLoginPage.clickSubmitButton()
  }


  Given("""^User login to the NINO GG Login Page$""") { () =>
    GGNINOLoginPage.navigateToAuthLoginStub()
    GGNINOLoginPage.enterRedirectURL()
    GGNINOLoginPage.selectConfidenceLevel()
    GGNINOLoginPage.enterNino()
    GGNINOLoginPage.selectSAEnrolment()
    GGNINOLoginPage.clickSubmitButton()
  }

  Given("""^User login to the NINO GG Login Page Without SA enrollment$""") { () =>
    GGNINOLoginPage.navigateToAuthLoginStub()
    GGNINOLoginPage.enterRedirectURL()
    GGNINOLoginPage.selectConfidenceLevel()
    GGNINOLoginPage.enterNino()
    GGNINOLoginPage.clickSubmitButton()
  }
  Given("""^User login to the NINO GG Login Page with PTA enrolment$""") { () =>
    GGNINOLoginPage.navigateToAuthLoginStub()
    GGNINOLoginPage.enterRedirectURL()
    GGNINOLoginPage.selectConfidenceLevel()
    GGNINOLoginPage.enterNino()
    GGNINOLoginPage.selectPTAEnrolment()
    GGNINOLoginPage.clickSubmitButton()
  }


  Given("""^I accesses the (.*) page with nino (.*)$""") { (url: String, nino: String) =>
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

  Given("""^User login to the activity Login Page$""") { () =>
    GGLoginPage.navigateToAuthLoginStub()
    GGLoginPage.enterRedirectActivityURL()
    GGLoginPage.selectConfidenceLevel()
    GGLoginPage.enterNino()
    GGLoginPage.selectSAEnrolment()
    GGLoginPage.clickSubmitButton()
  }

}
