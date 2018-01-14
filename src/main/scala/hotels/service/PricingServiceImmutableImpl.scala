package hotels.service

import java.util
import java.util.Optional

import utils.JavaConversions._
import utils.ScalaConversions._

import scala.annotation.tailrec

class PricingServiceImmutableImpl extends PricingService {
  override def findMaxPrice(prices: util.List[Integer]): Optional[Integer] = {
    findMaxPriceStateless(prices)
  }

  private def findMaxPriceStateless(prices: List[Int]): Option[Int] = {
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
