package hotels.service

import java.util
import java.util.Optional

import scala.collection.JavaConverters._
import org.scalatest.{FlatSpec, Matchers}


class JavaPricingServiceSpec extends FlatSpec with Matchers {

  val javaPricingService = new PricingServiceSimpleImpl

  "findMaxPrice" should "return None result when empty list of prices is passed" in {
    val unsortedPrices = util.Arrays.asList[Integer]()

    val sortedByPrice = javaPricingService.findMaxPrice(unsortedPrices)

    sortedByPrice shouldBe(Optional.empty[Integer]())
  }

  it should "return a sorted list in ascending order when a list of prices is passed" in {
    val unsortedPrices = List(50, 30, 45, 40).map(Integer.valueOf)

    val sortedByPrice = javaPricingService.findMaxPrice(unsortedPrices.asJava)

    sortedByPrice shouldBe(Optional.of(new Integer(50)))
  }
}
