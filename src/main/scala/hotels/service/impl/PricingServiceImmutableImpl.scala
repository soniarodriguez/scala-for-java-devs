package hotels.service.impl

import java.util.Optional
import java.{lang, util => ju}

import hotels.service.PricingService
import utils.JavaConversions._
import utils.ScalaConversions._

import scala.annotation.tailrec

/**
  * PricingServiceImmutableImpl will have methods written in a Functional Programming way. Therefore, in this class you
  * should not use `var` and it has stateless methods.
  *
  * Due to this Scala class is implementing a Java Interface, some workaround is needed to be done to convert some Java
  * types to Scala types. That's why you will only need to implement the private methods where everything is Scala type.
  * The transformations from/to Scala are done implicitly. We will see how this is done in future lessons.
  *
  * see @hotels.service.impl.PricingServiceSimpleImpl to know what the methods need to do
  */
class PricingServiceImmutableImpl extends PricingService {

  override def convertToExchangeRate(prices: ju.List[Integer], rate: lang.Float): ju.List[Integer] = {
    convertToExchangeRateAsScala(prices, rate)
  }

  override def findPricesBelowThreshold(prices: ju.List[Integer], threshold: Integer): ju.List[Integer] = {
    findPricesBelowThresholdAsScala(prices, threshold)
  }

  override def findMaxPrice(prices: ju.List[Integer]): Optional[Integer] = {
    findMaxPriceStatelessAsScala(prices)
  }

  private def convertToExchangeRateAsScala(prices: List[Int], rate: Float): List[Int] = {
    prices.map(price => convertPrice(price, rate))
  }

  private def convertPrice(price: Int, rate: Float): Int = (price * rate).round

  private def findPricesBelowThresholdAsScala(prices: List[Int], threshold: Int) = {
    prices.filter(price => price < threshold)
  }

  private def findMaxPriceStatelessAsScala(prices: List[Int]): Option[Int] = {
    findMaxPriceRecursively(prices, None)
  }

  @tailrec
  private def findMaxPriceRecursively(prices: List[Int], maybeMaxPrice: Option[Int]): Option[Int] = {
    prices match {
      case Nil => None
      case head :: Nil =>
        getNewMax(head, maybeMaxPrice)
      case head :: tail =>
        findMaxPriceRecursively(tail, getNewMax(head, maybeMaxPrice))
    }
  }

  private def getNewMax(currentPrice: Int, maybeMaxPrice: Option[Int]): Option[Int] =
    if (currentPrice > maybeMaxPrice.getOrElse(Int.MinValue)) Some(currentPrice) else maybeMaxPrice

}
