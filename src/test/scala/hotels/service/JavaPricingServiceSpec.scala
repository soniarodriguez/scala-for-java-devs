package hotels.service

import java.util
import java.util.Optional

import hotels.service.impl.{PricingServiceImmutableImpl, PricingServiceMutableImpl, PricingServiceSimpleImpl}
import org.scalatest.prop.TableDrivenPropertyChecks

import scala.collection.JavaConverters._
import org.scalatest.{FlatSpec, Matchers}


class JavaPricingServiceSpec extends FlatSpec with Matchers with TableDrivenPropertyChecks {

  val implementations = Table(
    ("pricingServiceImplType", "pricingServiceImpl"),
    ("javaPricingServiceImpl", new PricingServiceSimpleImpl),
    ("scalaPricingServiceMutableImpl", new PricingServiceMutableImpl),
    ("scalaPricingServiceImmutableImpl", new PricingServiceImmutableImpl)
  )

  forAll(implementations) { (pricingServiceImplType, pricingService) =>
    s"findPricesBelowThreshold using $pricingServiceImplType" should "return empty list when list is empty" in {
      val prices = util.Arrays.asList[Integer]()
      val threshold = 23

      val filteredPrices = pricingService.findPricesBelowThreshold(prices, threshold)

      filteredPrices shouldBe(prices)
    }

    s"findPricesBelowThreshold using $pricingServiceImplType" should "return same list when all prices are below the threshold" in {
      val prices =  List(5, 10, 15, 6).map(Integer.valueOf).asJava
      val threshold = 23

      val filteredPrices = pricingService.findPricesBelowThreshold(prices, threshold)

      filteredPrices shouldBe(prices)
    }

    s"findPricesBelowThreshold using $pricingServiceImplType" should "return filtered list for prices below the threshold" in {
      val prices =  List(30, 24, 15, 6).map(Integer.valueOf).asJava
      val threshold = 23

      val filteredPrices = pricingService.findPricesBelowThreshold(prices, threshold)

      filteredPrices shouldBe(List(15, 6).map(Integer.valueOf).asJava)
    }

    s"findPricesBelowThreshold using $pricingServiceImplType" should "filter price equal to threshold" in {
      val prices =  List(23, 24, 15).map(Integer.valueOf).asJava
      val threshold = 23

      val filteredPrices = pricingService.findPricesBelowThreshold(prices, threshold)

      filteredPrices shouldBe(List(15).map(Integer.valueOf).asJava)
    }

    s"findMaxPrice using $pricingServiceImplType" should "return None result when empty list of prices is passed" in {
      val unsortedPrices = util.Arrays.asList[Integer]()

      val sortedByPrice = pricingService.findMaxPrice(unsortedPrices)

      sortedByPrice shouldBe (Optional.empty[Integer]())
    }

    it should "return a sorted list in ascending order when a list of prices is passed" in {
      val unsortedPrices = List(50, 30, 45, 40).map(Integer.valueOf)

      val sortedByPrice = pricingService.findMaxPrice(unsortedPrices.asJava)

      sortedByPrice shouldBe (Optional.of(new Integer(50)))
    }
  }
}
