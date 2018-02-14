package hotels.service.impl

import hotels.domain.Hotel
import hotels.service.HotelService

class HotelServiceImpl extends HotelService {

  override def findHotelById(data: List[Hotel], id: Int): Option[Hotel] =
    data.find(hotel => hotel.id == id)

  override def findHotelsByCity(data: List[Hotel], city: String): List[Hotel] =
    data.filter(hotel => hotel.city == city)

  override def findCheapestHotel(data: List[Hotel]): Hotel =
    data.reduceLeft { (cheapestHotel, hotel) =>
      if (cheapestHotel.price <= hotel.price)
        cheapestHotel
      else
        hotel
    }
}
