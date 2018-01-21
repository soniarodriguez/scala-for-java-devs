package hotels.service.impl

import java.util.Optional
import java.{lang, util => ju}

import hotels.service.PricingService
import utils.JavaConversions._
import utils.ScalaConversions._

class PricingServiceMutableImpl extends PricingService {

  // This method receives and returns Java types since it implements the Java Interface. It will do the transformations
  // from/to Scala type implicitly. We will see how this is done in future lessons.
  override def convertToExchangeRate(prices: ju.List[Integer], rate: lang.Float): ju.List[Integer] = {
    convertToExchangeRateAsScala(prices, rate)
  }

  override def findPricesBelowThreshold(prices: ju.List[Integer], threshold: Integer): ju.List[Integer] = {
    findPricesBelowThresholdAsScala(prices, threshold)
  }

  override def findMaxPrice(prices: ju.List[Integer]): Optional[Integer] = {
    findMaxPriceUsingLoop(prices)
  }

  private def convertToExchangeRateAsScala(prices: List[Int], rate: Float): List[Int] = {
    val filteredPrices = new collection.mutable.ListBuffer[Int]
    for (price <- prices) {
        filteredPrices += convertPrice(price, rate)
    }
    filteredPrices.toList
  }

  private def convertPrice(price: Int, rate: Float): Int = (price * rate).round

  private def findPricesBelowThresholdAsScala(prices: List[Int], threshold: Int): List[Int] = {
    val filteredPrices = new collection.mutable.ListBuffer[Int]
    for (price <- prices) {
      if (price < threshold) {
        filteredPrices += price
      }
    }
    filteredPrices.toList
  }

  // You need implement this method which uses only Scala types.
  private def findMaxPriceUsingLoop(prices: List[Int]): Option[Int] = {
    // This implementation can be using mutable state (`var`).

    if (prices.isEmpty) {
      None
    } else {
      var maxPrice = Int.MinValue
      for (price <- prices) {
        if (price > maxPrice) {
          maxPrice = price
        }
      }
      Some(maxPrice)
    }
  }

  private def getNewMax(currentPrice: Int, maybeMaxPrice: Option[Int]): Option[Int] =
    if (currentPrice > maybeMaxPrice.getOrElse(Int.MinValue)) Some(currentPrice) else maybeMaxPrice
}
