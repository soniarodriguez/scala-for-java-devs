package hotels.service.impl


class NamesServiceImpl {

  def findLengthOfEachName(list: List[String]): List[Int] = {
    list.map(name => name.length)
  }

  def findAllNamesWithFirstLetter(list: List[String], firstLetter: String): List[String] = {
    list.filter(_.startsWith(firstLetter))
  }

  def findTotalLength(list: List[String]): Int = {
    list.foldLeft(0) { (acc, name) => acc + name.length }
  }

}
