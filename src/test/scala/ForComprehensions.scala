import org.scalatest.{FunSuite, Matchers}

class ForComprehensions extends FunSuite with Matchers {

  test("transform to for comprehension 1") {
    case class Hotel(name: String, city: String)

    val hotels = List(Hotel("Hilton", "London"), Hotel("Radisson", "Moscow"), Hotel("The Arch", "London"))

    //find all hotels names in London
    val expectedResult = hotels.filter(hotel => hotel.city.startsWith("London")).map(hotel => hotel.name)

    //TODO implement me
    val comprehensionResult = ???

    expectedResult shouldBe comprehensionResult
  }

  //Advanced
  test("transform to for comprehension 2") {
    case class Hotel(name: String, city: String)

    val hotels = List(Some(Hotel("Hilton", "London")), None, Some(Hotel("The Arch", "London")), Some(Hotel("Corinthia", "Amsterdam")))

    //find all hotels names in Amsterdam
    val expectedResult = hotels.flatMap(maybeHotel => maybeHotel.filter(hotel => hotel.city.startsWith("Ams")).map(hotel => hotel.name))

    //TODO implement me
    val comprehensionResult = ???

    expectedResult shouldBe comprehensionResult
  }

  //Advanced
  test("transform from comprehension") {
    case class Hotel(name: String, cities: List[String])

    val hotels = List(Hotel("Hilton", List("London", "New York")), Hotel("Radisson", List("Moscow", "San Diego")), Hotel("The Arch", List("Moscow", "Berlin")))

    //find all hotels names in Berlin
    val expectedResult =
      for {
        hotel <- hotels
        city <- hotel.cities
        if city.startsWith("Berlin")
      } yield hotel.name

    //TODO implement me
    val higherOrderFunRes = ???

    expectedResult shouldBe higherOrderFunRes
  }
}
