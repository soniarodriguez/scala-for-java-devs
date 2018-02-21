import org.scalatest.{FunSuite, Matchers}
import scala.{Option => _, Some => _, None => _} //Disable Option from the Standard Library

class CreatingOption extends FunSuite with Matchers {


  sealed trait Option[+A] {
    def map[B](f: A => B): Option[B] = ???
    def getOrElse[B>:A](default: => B): B = ???
    def orElse[B>:A](ob: => Option[B]): Option[B] = ???
    def filter(f: A => Boolean): Option[A] = ???
    def flatMap[B](f: A => Option[B]): Option[B] = ???

    def withFilter(f: A => Boolean): Option[A] = filter(f) // nothing to see here ... ask Greg if curious
  }

  case class Some[+A](get: A) extends Option[A]
  case object None extends Option[Nothing]




  test("Option.map") {
    Some(5).map(_.toString) shouldBe Some("5")
    None.map(_.toString) shouldBe None
  }

  test("Option.getOrElse") {
    Some(5).getOrElse(0) shouldBe 5
    None.getOrElse(0) shouldBe 0
  }

  test("Option.orElse") {
    Some(5) orElse None shouldBe Some(5)
    None orElse Some(5) shouldBe Some(5)
  }

  test("Option.filter") {
    Some(5).filter(i => i % 2 == 0) shouldBe None
    Some(4).filter(i => i % 2 == 0) shouldBe Some(4)
  }

  test("Option.flatMap") {

    val o1 = for {
      a <- Some(1)
      b <- Some(2)
    } yield a + b

    o1 shouldBe Some(3)


    val o2 = for {
      a <- Some(1)
      b <- None: Option[Int]
    } yield a + b

    o2 shouldBe None
  }

  test("flatMap, map, and filter") {

    val result = for {
      a <- Some(1)
      b <- Some(2)
      c = a + b
      if c % 2 == 1
    } yield c

    result shouldBe Some(3)
  }

}
