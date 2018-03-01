import java.io.InputStream
import java.net.URLConnection
import scala.util.Try
import java.net.URL
import scala.io.Source
import org.scalatest.{FunSuite, Matchers}

class ErrorHandling extends FunSuite with Matchers {

  /*
  *
  * Exercise - Lesson 6
  *
  * The goal is to implement getContentAsString method which would return
  * website's sourcecode as String.
  *
  * Firstly, implement the private methods and then think how to
  * combine them in the getContentAsString method.
  *
  * P.S. Every Java method you'll possibly use can throw an exception
  *
  * */

  // HINT: use Java URL
  private def parseURL(url: String) = ???

  // HINT: use the same method name on Java URL
  private def openConnection(url: URL) = ???

  // HINT: use the same method name on Java URLConnection
  private def getInputStream(connection: URLConnection) = ???


  // HINT1: use for comprehension to chain all calls
  // HINT2: use Scala Source.fromInputStream
  def getContentAsString(url: String): Try[String] = ???


  test("Successfully get the content as String") {
    getContentAsString("https://soniarodriguez.github.io/scala-for-java-devs/").get.contains("Fullstack Scala") shouldBe true
  }

  test("Fail with error message as String") {
    getContentAsString("blah").get shouldBe "no protocol: blah"
  }
}
