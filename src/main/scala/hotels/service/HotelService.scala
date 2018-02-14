package hotels.service

import hotels.domain.Hotel


trait HotelService {
  def findHotelById(hotels: List[Hotel], id: Int): Option[Hotel]

  def findHotelsByCity(hotels: List[Hotel], city: String): List[Hotel]

  def findCheapestHotel(hotels: List[Hotel]): Hotel
}
