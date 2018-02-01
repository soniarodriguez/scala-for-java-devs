package hotels.service.impl


class NamesServiceImpl {

  private val guestNames = List("Sonia", "Greg", "Povilas", "Angela", "John", "Adam", "Avinash", "Laura")

  def findLengthOfEachName(list: List[String]): List[Int] = {
    list.map(name => name.length)
  }

  //find all names which start with particular letter
  def findAllNamesWithFirstLetter(list: List[String], firstLetter: String): List[String] = {
    list.filter(_.startsWith(firstLetter))
  }

  //find total number of characters in the list of names
  def findTotalLength(list: List[String]): Int = {
    list.foldLeft(0) { (acc, name) => acc + name.length }
  }

}
