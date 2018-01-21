package hotels.service.impl

import java.util

import hotels.service.FileReader

import scala.collection.JavaConverters._

class FileReaderImpl extends FileReader {
  override def readFile(sourcePath: String): util.List[String] = {
    readFileInScala(sourcePath).asJava
  }

  private def readFileInScala(sourcePath: String): List[String] = {
    ???
  }
}
