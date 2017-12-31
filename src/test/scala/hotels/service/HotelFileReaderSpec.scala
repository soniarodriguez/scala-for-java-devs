package hotels.service

import org.scalatest.{FlatSpec, Matchers}
import scala.collection.JavaConverters._

class HotelFileReaderSpec extends FlatSpec with Matchers {

  val implementations = Seq(new HotelFileReaderCsvImpl)

  for(hotelLoaderImpl <- implementations) {
    "A file doesn't exit" should "return empty list" in {
      hotelLoaderImpl.readFile("/non-exists-file.csv").asScala shouldBe Nil
    }

    "An empty file" should "return empty list" in {
      hotelLoaderImpl.readFile("/hotels-empty.csv").asScala shouldBe Nil
    }

    "A file with several hotels" should "return a list of hotel names" in {
      val hotels = hotelLoaderImpl.readFile("/hotels.csv")

      hotels.asScala shouldBe List(
        "Corinthia Hotel London",
        "Jumeirah Carlton Tower",
        "DoubleTree by Hilton London-Islington")
    }
  }

}
