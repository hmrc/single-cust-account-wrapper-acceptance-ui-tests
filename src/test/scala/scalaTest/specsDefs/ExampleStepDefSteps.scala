/*
 * Copyright 2025 HM Revenue & Customs
 *
 */

package scalaTest.specsDefs

import uk.gov.hmrc.test.ui.pages.CheckYourVATResult.*
import uk.gov.hmrc.test.ui.pages.CheckYourVATHomePage
import uk.gov.hmrc.test.ui.pages.CheckYourVATHomePage.provideVATPeriod

object ExampleStepDefSteps {

  // I am on the Check your VAT flat rate service
  def givenIAmOnTheCheckYourVATFlatRateService(): Unit = {
    CheckYourVATHomePage.loadPage
  }

  // I submit my VAT for goods under £1000 for the year
  def whenISubmitMyVATForGoodsUnder1000ForTheYear(): Unit = {
    provideVATPeriod("Annually")
          .provideTurnoverAmount("1000")
          .provideCostOfGoodsAmount("999")
          .submitVATInformation
  }

  // I submit my VAT information for goods over £1000 for the year
  def whenISubmitMyVATInformationForGoodsOver1000ForTheYear(): Unit = {
    provideVATPeriod("Annually")
          .provideTurnoverAmount("1000")
          .provideCostOfGoodsAmount("1000")
          .submitVATInformation
  }

  // I submit my VAT information for goods under £250 for the quarter
  def whenISubmitMyVATInformationForGoodsUnder250ForTheQuarter(): Unit = {
    provideVATPeriod("Quarterly")
          .provideTurnoverAmount("1000")
          .provideCostOfGoodsAmount("249")
          .submitVATInformation
  }

  // I submit my VAT information for goods for £250 for the quarter
  def whenISubmitMyVATInformationForGoodsFor250ForTheQuarter(): Unit = {
    provideVATPeriod("Quarterly")
          .provideTurnoverAmount("1000")
          .provideCostOfGoodsAmount("250")
          .submitVATInformation
  }

  // I will be asked to use the 16.5% VAT flat rate
  def thenIWillBeAskedToUseThe16VATFlatRate(): Unit = {
    result.equals(useSetVATFlatRate)
  }

  // I will be asked to use the VAT flat rate
  def thenIWillBeAskedToUseTheVATFlatRate(): Unit = {
    result.equals(useUniqueVATFlatRate)
  }

}
