# Scala for Java developers



## Lesson 4. 
Let's practise what we have learnt so far using traits and case classes. 


1. Implements the method `getHotelNames` in `HotelServiceImpl`, which receives a list of hotels and it will return the
 list of each hotel name preserving the order.
 
 ```
  def getHotelNames(hotels: List[Hotel]): List[String] = ???
 ```
 
 
2. Implements the method `findHotelById` in `HotelServiceImpl`, which receives a list of hotels and an id and it will
  return the hotel found for that id in a safe way (using `Option`).
  
 ```
  def findHotelById(hotels: List[Hotel], id: Int): Option[Hotel] = ???
 ```
 
  
3. Implements the method `findHotelsByCity` in `HotelServiceImpl`, which receives a list of hotels and a city name and
 it will return the list of hotels found in that city.
 
 ```
 def findHotelsByCity(hotels: List[Hotel], city: String): List[Hotel] = ???
 ```
  
  
4. Implements the method `findCheapestHotel` in `HotelServiceImpl`, which receives a list of hotels and
 it will return the hotel whose price is the cheapest one. Assume no empty list will be received.
 
 ```
 def findCheapestHotel(hotels: List[Hotel]): Hotel = ???
 ```
 
 
 * **Remember**: Try to use `map`, `filter`, `find`, `fold`, `foldLeft`, `foldRight`, `reduceLeft `& `reduceRight`, `Option`
 or for-comprenhension.