package hotels.service.impl

import java.util

import hotels.service.FileReader

import scala.collection.JavaConverters._


/**
  * Due to this Scala class is implementing a Java Interface, some workaround is needed to be done to convert some Java
  * types to Scala types. That's why you will only need to implement the private methods where everything is Scala type.
  * The transformations from/to Scala are done implicitly. We will see how this is done in future lessons.
  *
  * see @hotels.service.impl.FileReaderStreamImpl or @hotels.service.impl.FileReaderClassicImpl to know what the method
  * needs to do.
  */
class FileReaderImpl extends FileReader {
  override def readFile(sourcePath: String): util.List[String] = {
    readFileAsScala(sourcePath).asJava
  }

  private def readFileAsScala(sourcePath: String): List[String] = {
    // TODO
    ???
  }
}
