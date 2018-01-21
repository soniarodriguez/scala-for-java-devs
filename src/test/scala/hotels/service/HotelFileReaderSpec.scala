package hotels.service

import hotels.service.impl.{FileReaderClassicImpl, FileReaderImpl, FileReaderStreamImpl}
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks

import scala.collection.JavaConverters._

class HotelFileReaderSpec extends FlatSpec with Matchers with TableDrivenPropertyChecks {

  val implementations = Table(
    ("fileReaderImplType", "fileReaderImpl", "prefixFile"),
    ("fileReaderStream implementation", new FileReaderStreamImpl, "/"),
    ("fileReaderClassic implementation", new FileReaderClassicImpl, "/"),
    ("fileReaderScala implementation", new FileReaderImpl, "")
  )

  forAll(implementations) {
    (fileReaderImplType, fileReaderImpl, prefixFile) =>

      s"readFile using $fileReaderImplType" should "return empty list when a file doesn't exit" in {
        fileReaderImpl.readFile(s"${prefixFile}non-exists-file.csv").asScala shouldBe Nil
      }

      it should "return empty list when the file is empty" in {
        fileReaderImpl.readFile(s"${prefixFile}hotels-empty.csv").asScala shouldBe Nil
      }

      it should "return a list of hotel names when the file contains several hotels" in {
        val hotels = fileReaderImpl.readFile(s"${prefixFile}hotels.csv")

        hotels.asScala shouldBe List(
          "Corinthia Hotel London",
          "Jumeirah Carlton Tower",
          "DoubleTree by Hilton London-Islington")
      }
  }

}
