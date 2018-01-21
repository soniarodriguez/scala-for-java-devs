package hotels.service.impl

import java.util.Optional
import java.{util => ju}

import hotels.service.PricingService
import utils.JavaConversions._
import utils.ScalaConversions._

import scala.annotation.tailrec

class PricingServiceImmutableImpl extends PricingService {
  // This method receives and returns Java types since it implements the Java Interface. It will do the transformations
  // from/to Scala type implicitly. We will see how this is done in future lessons.
  override def findPricesBelowThreshold(prices: ju.List[Integer], threshold: Integer): ju.List[Integer] = {
    findPricesBelowThresholdAsScala(prices, threshold)
  }

  override def findMaxPrice(prices: ju.List[Integer]): Optional[Integer] = {
    findMaxPriceStatelessAsScala(prices)
  }

  private def findPricesBelowThresholdAsScala(prices: List[Int], threshold: Int): List[Int] = {
    prices.filter(price => price < threshold)
  }

  // You need implement this method which uses only Scala types.
  private def findMaxPriceStatelessAsScala(prices: List[Int]): Option[Int] = {
    // This implementation should not use mutable variables (`var`).
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
