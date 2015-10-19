package practise.chapter10implicit

//Read http://docs.scala-lang.org/overviews/collections/conversions-between-java-and-scala-collections.html
class Exercise4Javaconversions extends org.scalatest.FunSuite {
  object Exercise {
    //Use scala.collection.JavaConversions to automatically change java lists to scala
    //Then return only the strings with length 1
    //hint: toList
    def letters(javaList: java.util.List[String]): List[String] = ???
  }
  import Exercise._

  test("letters") {
    val javaList: java.util.List[String] = new java.util.ArrayList[String]()
    javaList.add("a")
    javaList.add("blabla")
    javaList.add("b")
    javaList.add("lalala")
    assert(letters(javaList) === List("a", "b"))
  }

}