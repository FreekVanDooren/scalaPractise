package practise.chapter8implicit

//Read http://docs.scala-lang.org/overviews/core/implicit-classes.html
class Exercise2ImplicitConversions extends org.scalatest.FunSuite {
  object Exercise {
    //Create a class HelloString, which can be implicitly created from a String
    //and define the method hello on it
  }
  //startAnswer
  object Answer {
    implicit class HelloString(val from: String) {
      def hello = s"Hello $from"
    }
  }
  import Answer._
  //endAnswer

//Uncomment this test
//  test("Hello World") {
//    assert("World".hello === "Hello World")
//  }

}
