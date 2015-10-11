package practise.chapter8implicit

//Read http://docs.scala-lang.org/overviews/collections/conversions-between-java-and-scala-collections.html
class Exercise4Javaconversions extends org.scalatest.FunSuite {
  object Exercise {
    //Use scala.collection.JavaConversions to automatically change java lists to scala
    //Then return only the letters
    def letters(javaList: java.util.List[String]) = ???
  }
  //startAnswer
  object Answer {
    import scala.collection.JavaConversions._
    def letters(javaList: java.util.List[String]) = javaList.filter { _.length == 1 }
  }
  import Answer._
  //endAnswer

  test("letters") {
    val javaList: java.util.List[String] = new java.util.ArrayList[String]()
    javaList.add("a")
    javaList.add("blabla")
    javaList.add("b")
    javaList.add("lalala")
    assert(letters(javaList) === List("a", "b"))
  }

}
