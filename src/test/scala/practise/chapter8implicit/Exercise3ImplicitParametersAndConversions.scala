package practise.chapter8implicit

//Read http://docs.scala-lang.org/overviews/core/implicit-classes.html
class Exercise3ImplicitParametersAndConversions extends org.scalatest.FunSuite {
  object Exercise {
    //Create a class HelloString, which can be implicitly created from a String
    //and define the method greet on it
  }
  //startAnswer
  object Answer {
    implicit class HelloString(val from: String) {
      def greet(implicit greeting: String) = s"$greeting $from"
    }
  }
  import Answer._
  //endAnswer

//Uncomment these tests
//  test("Hello World") {
//    implicit val greeting = "Hello"
//    assert("World".greet === "Hello World")
//  }
//
//  test("Hallo Wereld") {
//    implicit val greeting = "Hallo"
//    assert("Wereld".greet === "Hallo Wereld")
//  }

}
