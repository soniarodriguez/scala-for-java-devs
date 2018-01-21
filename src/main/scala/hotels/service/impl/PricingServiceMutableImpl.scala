package hotels.service.impl

import java.util.Optional
import java.{lang, util => ju}

import hotels.service.PricingService
import utils.JavaConversions._
import utils.ScalaConversions._


/**
  * PricingServiceMutableImpl will have methods written in a Imperative Programming way. Therefore, in this class you
  * can use `var` and it has stateful methods.
  *
  * Due to this Scala class is implementing a Java Interface, some workaround is needed to be done to convert some Java
  * types to Scala types. That's why you will only need to implement the private methods where everything is Scala type.
  * The transformations from/to Scala are done implicitly. We will see how this is done in future lessons.
  *
  * see @hotels.service.impl.PricingServiceSimpleImpl to know what the methods need to do
  */
class PricingServiceMutableImpl extends PricingService {

  override def convertToExchangeRate(prices: ju.List[Integer], rate: lang.Float): ju.List[Integer] = {
    convertToExchangeRateAsScala(prices, rate)
  }

  override def findPricesBelowThreshold(prices: ju.List[Integer], threshold: Integer): ju.List[Integer] = {
    findPricesBelowThresholdAsScala(prices, threshold)
  }

  override def findMaxPrice(prices: ju.List[Integer]): Optional[Integer] = {
    findMaxPriceAsScala(prices)
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

  private def findMaxPriceAsScala(prices: List[Int]): Option[Int] = {
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

}
