import org.scalatest.{FunSuite, Matchers}

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

class AsyncServiceSpec extends FunSuite with Matchers {
  val asyncService = new AsyncService(new SyncService)

  test("Return a completed successful future with the value passed") {
    val result = asyncService.expectedSuccessfulFuture(10)

    Await.result(result, 5.millis) shouldBe 10
  }

  test("Return a failed completed future with the exception passed") {
    val result = asyncService.expectedFailedFuture(new RuntimeException("Service fails as expected"))

    intercept[RuntimeException] {
      Await.result(result, 5.millis)
    }
  }

  test("Return a future that will return a product after 100ms") {
    val result = asyncService.getProduct("tv")

    Await.result(result, 105.millis) shouldBe "tv"
  }

  test("Return a future that will return a price after 100ms") {
    val result = asyncService.getPrice(402.5f)

    Await.result(result, 105.millis) shouldBe 402.5f
  }

  test("Return the item price value multiply by number of items") {
    val result = asyncService.getTotalPrice(Future.successful(100f), 3)

    Await.result(result, 10.millis) shouldBe 300f
  }

  test("Get the price for Kindle line") {
    val result = asyncService.getPriceForKindleLine()

    Await.result(result, 105.millis) shouldBe  "Kindle: 59.99£"
  }

  test("Get the price for Kindle line with several items") {
    val result = asyncService.getPriceForSeveralKindles(10)

    Await.result(result, 105.millis) shouldBe  "Kindle: 599.9£"
  }
}
