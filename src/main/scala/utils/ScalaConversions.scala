package utils

import java.util.Optional
import java.{lang => jl}

import scala.collection.JavaConverters._

object ScalaConversions {

  implicit def asScalaMaybeInteger(maybeInteger: Optional[Integer]): Option[Int] = {
    if (maybeInteger.isPresent) {
      Some(maybeInteger.get())
    } else {
      None
    }
  }

  implicit def asScalaIteratorInteger(someIntegers: jl.Iterable[Integer]): List[Int] = {
    someIntegers.asScala.map(_.toInt).toList
  }
}


