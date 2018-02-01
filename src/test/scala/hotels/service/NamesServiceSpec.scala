package hotels.service

import hotels.service.impl.NamesServiceImpl
import org.scalatest.{FlatSpec, Matchers}

class NamesServiceSpec extends FlatSpec with Matchers {

  private val guestNames = List("Sonia", "Greg", "Povilas", "Angela", "John", "Adam", "Avinash", "Laura")
  private val namesService = new NamesServiceImpl


  it should "return the length of each name" in {
    val lengthList = namesService.findLengthOfEachName(guestNames)

    lengthList shouldBe List(5, 4, 7, 6, 4, 4, 7, 5)
  }

  it should "return all names which start with letter A" in {
    val filteredNames = namesService.findAllNamesWithFirstLetter(guestNames, "A")

    filteredNames shouldBe List("Angela", "Adam", "Avinash")
  }

  it should "return total number of characters in the list" in {
    val totalLen = namesService.findTotalLength(guestNames)

    totalLen shouldBe 42
  }

}