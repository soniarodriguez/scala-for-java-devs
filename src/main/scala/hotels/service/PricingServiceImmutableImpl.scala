package hotels.service

import java.util
import java.util.Optional

import utils.JavaConversions._
import utils.ScalaConversions._

import scala.annotation.tailrec

class PricingServiceImmutableImpl extends PricingService {
  // This method receives and returns Java types since it implements the Java Interface. It will do the transformations
  // from/to Scala type implicitly. We will see how this is done in future lessons.
  override def findMaxPrice(prices: util.List[Integer]): Optional[Integer] = {
    findMaxPriceStateless(prices)
  }
  // You need implement this method which uses only Scala types.
  private def findMaxPriceStateless(prices: List[Int]): Option[Int] = {
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
