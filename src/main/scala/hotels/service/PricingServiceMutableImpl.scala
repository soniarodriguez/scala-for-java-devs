package hotels.service
import java.util
import java.util.Optional

import utils.JavaConversions._
import utils.ScalaConversions._

class PricingServiceMutableImpl extends PricingService {
  override def findMaxPrice(prices: util.List[Integer]): Optional[Integer] = {
    findMaxPriceUsingLoop(prices)
  }

  private def findMaxPriceUsingLoop(prices: List[Int]): Option[Int] = {
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
