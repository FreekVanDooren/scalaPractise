import java.io.{PrintWriter, File}

import scala.io.Source

def filterStart(lines: List[String]): List[String] = lines match {
  case Nil =>
    println("no answer found!")
    Nil
  case "  //startAnswer" :: rest => "  import Exercise._" :: filterMiddle(rest)
  case first :: rest => first :: filterStart(rest)
}

def filterMiddle(lines: List[String]): List[String] = lines match {
  case "  //endAnswer" :: rest => rest
  case _ :: rest => filterMiddle(rest)
}

val chapters: List[File] = new File("src/test/scala/practise").listFiles.filter(_.isDirectory).toList
val exercises = chapters.flatMap { _.listFiles }
exercises.foreach { exercise: File =>
  val fileName = exercise.getPath
  println("converting " + fileName)
  val inputLines: List[String] = Source.fromFile(exercise).getLines().toList
  val outputLines = filterStart(inputLines)
  val output = outputLines.mkString("\n")
  new PrintWriter(fileName) {
    write(output)
    close()
  }
}