

class SyncService {

  def getProduct(product: String): String = {
    Thread.sleep(100)
    product
  }

  def getPrice(price: Float): Float = {
    Thread.sleep(100)
    price
  }

  // Return the itemPrice value multiply by number of items
  def getTotalPrice(itemPrice: Float, items: Int): Float = {
    itemPrice * items
  }

  // Using getProduct and getPrice, and return "Kindle: 59.99£"
  def getPriceForKindleLine(): String = {
    val product = getProduct("Kindle")
    val price = getPrice(59.99f)
    s"$product: ${price}£"
  }

  // Hint: modify getPriceForKindle
  def getPriceForSeveralKindles(items: Int): String = {
    val product = getProduct("Kindle")
    val price = getPrice(59.99f)

    s"$product: ${price*items}£"
  }

}
