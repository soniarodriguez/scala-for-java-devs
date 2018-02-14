package hotels.service

import hotels.domain.Hotel
import hotels.service.impl.HotelServiceImpl
import org.scalatest.{FlatSpec, Matchers}


class HotelServiceImplSpec extends FlatSpec with Matchers {

  private val hotels = List(
    Hotel(1, "Hilton London Canary Wharf", "London", 111),
    Hotel(2, "AC Porte Maillot Hotel", "Paris", 169),
    Hotel(3, "AC Hotel Atocha", "Madrid", 97),
    Hotel(4, "Hotel l'Antoine", "Paris", 119)
  )
  private val hotelsService = new HotelServiceImpl


  "findHotelById" should "return the found hotel with the indicated id" in {
    val hotelsInParis = hotelsService.findHotelById(hotels, 2)

    hotelsInParis shouldBe Some(Hotel(2, "AC Porte Maillot Hotel", "Paris", 169))
  }

  it should "return None when no hotel found for the indicated id" in {
    val hotelsInParis = hotelsService.findHotelById(hotels, 10)

    hotelsInParis shouldBe None
  }

  it should "return None when the hotels list is empty" in {
    val hotelsInParis = hotelsService.findHotelById(List.empty[Hotel], 10)

    hotelsInParis shouldBe None
  }

  "findHotelsByCity" should "return a list of the hotels located in the indicated city" in {
    val hotelsInParis = hotelsService.findHotelsByCity(hotels, "Paris")

    hotelsInParis shouldBe List(
      Hotel(2, "AC Porte Maillot Hotel", "Paris", 169),
      Hotel(4, "Hotel l'Antoine", "Paris", 119)
    )
  }

  it should "return empty list if there are no hotels in the indicated city" in {
    val hotelsInRome = hotelsService.findHotelsByCity(hotels, "Rome")

    hotelsInRome shouldBe List.empty[Hotel]
  }

  it should "return empty list if the passed list is empty" in {
    val hotelsInRome = hotelsService.findHotelsByCity(List.empty[Hotel], "Paris")

    hotelsInRome shouldBe List.empty[Hotel]
  }


  "findCheapestHotel" should "return the hotel with the cheapest price" in {
    val cheapestHotel = hotelsService.findCheapestHotel(hotels)

    cheapestHotel shouldBe Hotel(3, "AC Hotel Atocha", "Madrid", 97)
  }

}
