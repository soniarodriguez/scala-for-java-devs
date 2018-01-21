package utils

import java.util.Optional
import java.{util => ju}

import scala.collection.JavaConverters._

object ScalaConversions {

  implicit def asScalaMaybeInteger(maybeInteger: Optional[Integer]): Option[Int] = {
    if (maybeInteger.isPresent) {
      Some(maybeInteger.get())
    } else {
      None
    }
  }

  implicit def asScalaIteratorInteger(someIntegers: ju.List[Integer]): List[Int] = {
    someIntegers.asScala.map(_.toInt).toList
  }
}


