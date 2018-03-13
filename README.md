# Scala for Java developers



## Lesson 7 - Futures

Implements all methods in AsyncService.

1. Create a completed successful future that returns the value passed
  ```
    def expectedSuccessfulFuture(value: Int): Future[Int]
  ```

2. Create a completed failed future with the exception passed
  ```
    def expectedFailedFuture(exception: Throwable): Future[Int]
  ```
  
3. Create a future that will return a product name after 100ms
  ```
    def getProduct(product: String): Future[String]
  ```

4. Create a future that will return a price after 100ms
  ```
    def getPrice(price: Float): Future[Float]
  ```

5. Return the item price value multiply by the number of items
  ```
    def getTotalPrice(itemPrice: Future[Float], items: Int)
  ```
  
6. Make use of `getProduct` and `getPrice`. Return a string with the following format "Kindle: 59.99£"
  ```
    def getPriceForKindleLine()
  ```

7. Make use of `getProduct` and `getPrice`. Return a string with the following format "Kindle: total_price£"
  ```
    def getPriceForSeveralKindles(items: Int): Future[String]
  ```
