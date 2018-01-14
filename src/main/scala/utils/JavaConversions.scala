package utils

import java.util.Optional
import java.{lang => jl}

import scala.collection.JavaConverters._

object JavaConversions {

  implicit def asJavaMaybeInteger(maybeInteger: Option[Int]): Optional[Integer] = {
    maybeInteger match {
      case None => Optional.empty()
      case Some(number) => Optional.of(number)
    }
  }

  implicit def asJavaIteratorInteger(someIntegers: Iterable[Int]): jl.Iterable[Integer] = {
    someIntegers.map(Integer.valueOf).asJava
  }
}
