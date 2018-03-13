import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


class AsyncService {

  // Create a completed successful future with the value passed
  def expectedSuccessfulFuture(value: Int): Future[Int] = ???

  // Create a completed failed future with the exception passed
  def expectedFailedFuture(exception: Throwable): Future[Int] = ???

  // Create a future that will return a product after 100ms
  def getProduct(product: String): Future[String] = ???

  // Create a future that will return a price after 100ms
  def getPrice(price: Float): Future[Float] = ???

  // Return the itemPrice value multiply by number of items
  def getTotalPrice(itemPrice: Future[Float], items: Int): Future[Float] = ???

  // Using getProduct and getPrice, and return "Kindle: 59.99£"
  def getPriceForKindleLine(): Future[String] = ???

  // Hint: modify getPriceForKindle
  def getPriceForSeveralKindles(items: Int): Future[String] = ???



}
