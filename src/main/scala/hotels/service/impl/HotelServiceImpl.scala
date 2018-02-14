package hotels.service.impl

import hotels.domain.Hotel
import hotels.service.HotelService

class HotelServiceImpl extends HotelService {
  
  override def getHotelNames(hotels: List[Hotel]): List[String] =
    hotels.map(hotel => hotel.name)

  override def findHotelById(hotels: List[Hotel], id: Int): Option[Hotel] =
    hotels.find(hotel => hotel.id == id)

  override def findHotelsByCity(hotels: List[Hotel], city: String): List[Hotel] =
    hotels.filter(hotel => hotel.city == city)

  override def findCheapestHotel(hotels: List[Hotel]): Hotel = {
    hotels.reduceLeft { (cheapestHotel, hotel) =>
      if (cheapestHotel.price <= hotel.price)
        cheapestHotel
      else
        hotel
    }
  }

  // When hotels list can be empty
  //  def findCheapestHotel(hotels: List[Hotel]): Option[Hotel] = {
  //
  //    hotels.foldLeft(Option.empty[Hotel]) { (maybeCheapestHotel, hotel) =>
  //      if (maybeCheapestHotel.isDefined && maybeCheapestHotel.get.price <= hotel.price)
  //        maybeCheapestHotel
  //      else
  //        Some(hotel)
  //    }
  //  }
}
