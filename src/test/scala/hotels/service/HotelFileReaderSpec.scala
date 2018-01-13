package hotels.service

import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks
import scala.collection.JavaConverters._

class HotelFileReaderSpec extends FlatSpec with Matchers with TableDrivenPropertyChecks {

  val implementations = Table(
    ("fileReaderImplType", "fileReaderImpl"),
    ("fileReaderStream implementation", new FileReaderStreamImpl),
    ("fileReaderClassic implementation", new FileReaderClassicImpl))

  forAll(implementations) {
    (fileReaderImplType, fileReaderImpl) =>


      s"readFile using $fileReaderImplType" should "return empty list when a file doesn't exit" in {
        fileReaderImpl.readFile("/non-exists-file.csv").asScala shouldBe Nil
      }

      it should "return empty list when the file is empty" in {
        fileReaderImpl.readFile("/hotels-empty.csv").asScala shouldBe Nil
      }

      it should "return a list of hotel names when the file contains several hotels" in {
        val hotels = fileReaderImpl.readFile("/hotels.csv")

        hotels.asScala shouldBe List(
          "Corinthia Hotel London",
          "Jumeirah Carlton Tower",
          "DoubleTree by Hilton London-Islington")
      }
  }

}
