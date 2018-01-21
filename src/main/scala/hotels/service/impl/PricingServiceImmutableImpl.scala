package hotels.service.impl

import java.util.Optional
import java.{lang, util => ju}

import hotels.service.PricingService
import utils.JavaConversions._
import utils.ScalaConversions._


class PricingServiceImmutableImpl extends PricingService {

  // This method receives and returns Java types since it implements the Java Interface. It will do the transformations
  // from/to Scala type implicitly. We will see how this is done in future lessons.
  override def convertToExchangeRate(prices: ju.List[Integer], rate: lang.Float): ju.List[Integer] = {
    convertToExchangeRateAsScala(prices, rate)
  }

  override def findPricesBelowThreshold(prices: ju.List[Integer], threshold: Integer): ju.List[Integer] = {
    findPricesBelowThresholdAsScala(prices, threshold)
  }

  override def findMaxPrice(prices: ju.List[Integer]): Optional[Integer] = {
    findMaxPriceStatelessAsScala(prices)
  }

  private def convertToExchangeRateAsScala(prices: List[Int], rate: Float): List[Int] = ???

  private def findPricesBelowThresholdAsScala(prices: List[Int], threshold: Int): List[Int] = {
    ???
  }

  // You need implement this method which uses only Scala types.
  private def findMaxPriceStatelessAsScala(prices: List[Int]): Option[Int] = {
    // This implementation should not use mutable variables (`var`).
    ???
  }
}
