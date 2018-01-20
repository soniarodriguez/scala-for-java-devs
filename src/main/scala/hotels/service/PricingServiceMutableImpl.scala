package hotels.service
import java.util
import java.util.Optional

import utils.JavaConversions._
import utils.ScalaConversions._

class PricingServiceMutableImpl extends PricingService {
  // This method receives and returns Java types since it implements the Java Interface. It will do the transformations
  // from/to Scala type implicitly. We will see how this is done in future lessons.
  override def findMaxPrice(prices: util.List[Integer]): Optional[Integer] = {
    findMaxPriceUsingLoop(prices)
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
