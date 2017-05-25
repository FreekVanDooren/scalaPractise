package practise.chapter10implicit

import scala.collection.immutable.StringOps

//Read http://docs.scala-lang.org/overviews/core/implicit-classes.html
class Exercise2ImplicitConversions extends org.scalatest.FunSuite {
  object Exercise {
    //Create a class HelloString, which can be implicitly created from a String
    //and define the method hello on it

    implicit class HelloString(val value: String) {
      def hello: String = "Hello " + value
    }

  }
  import Exercise._

//Uncomment this test
  test("Hello World") {
    assert("World".hello === "Hello World")
  }

}