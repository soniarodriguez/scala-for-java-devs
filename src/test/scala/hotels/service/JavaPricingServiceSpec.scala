package hotels.service

import java.util
import java.util.Optional

import org.scalatest.prop.TableDrivenPropertyChecks

import scala.collection.JavaConverters._
import org.scalatest.{FlatSpec, Matchers}


class JavaPricingServiceSpec extends FlatSpec with Matchers with TableDrivenPropertyChecks {

  val implementations = Table(
    ("pricingServiceImplType", "pricingServiceImpl"),
    ("javaPricingServiceImpl", new PricingServiceSimpleImpl),
    ("scalaPricingServiceImpl", new PricingServiceImpl)
  )

  forAll(implementations) { (pricingServiceImplType, pricingService) =>
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
