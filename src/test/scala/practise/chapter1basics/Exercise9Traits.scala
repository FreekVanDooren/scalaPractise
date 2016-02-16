package practise.chapter1basics

import org.scalatest.FunSuite

//Read http://www.scala-lang.org/old/node/126
class Exercise9Traits extends FunSuite {
  trait Shape {
    def describe: String //describes what the shape looks like
  }
  
  object Exercise {
    //Create a Triangle class
    //and override the describe method
    val triangle: Shape = ???
    //And the same for circle
    val circle: Shape = ???
  }
  import Exercise._

  test("a triangle is pointy") {
    assert(triangle.describe === "pointy")
  }

  test("a circle is round") {
    assert(circle.describe === "round")
  }

}