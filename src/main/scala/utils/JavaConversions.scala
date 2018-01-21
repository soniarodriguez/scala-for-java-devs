package utils

import java.util.Optional
import java.{util => ju}

import scala.collection.JavaConverters._

object JavaConversions {

  implicit def asJavaMaybeInteger(maybeInteger: Option[Int]): Optional[Integer] = {
    maybeInteger match {
      case None => Optional.empty()
      case Some(number) => Optional.of(number)
    }
  }

  implicit def asJavaListInteger(someIntegers: List[Int]): ju.List[Integer] = {
    someIntegers.map(Integer.valueOf).asJava
  }
}
