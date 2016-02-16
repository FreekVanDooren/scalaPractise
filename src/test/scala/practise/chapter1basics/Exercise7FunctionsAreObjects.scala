package practise.chapter1basics

import org.scalatest.FunSuite

//read: https://twitter.github.io/scala_school/basics2.html#object
//and https://twitter.github.io/scala_school/basics2.html#fnobj
//Notice that functions have a type and we can treat them as objects
class Exercise7FunctionsAreObjects extends FunSuite {
  object Exercise {
    def function1: Function1[Int, Int] = ???
    def function2 = ???
    def listOfFunctions: List[Function1[Int, Int]] = List(function1, function2)
  }
  //startAnswer
  object Answer {
    def function1: Function1[Int, Int] = { _ + 1 }
    def function2 = { x: Int => x + 2 }
    def listOfFunctions: List[Function1[Int, Int]] = List(function1, function2)
  }
  import Answer._
  //endAnswer

  test("function1") {
    assert(function1(0) === 1)
    assert(function1(1) === 2)
    assert(function1(2) === 3)
  }

  test("listOfFunctions") {
    assert(listOfFunctions.size === 2)
    val firstFunction = listOfFunctions.head
    val secondFunction = listOfFunctions(1)
    assert(firstFunction(1) === 2)
    assert(firstFunction(2) === 3)
    assert(firstFunction(3) === 4)
    assert(secondFunction(1) === 3)
    assert(secondFunction(2) === 4)
    assert(secondFunction(3) === 5)
  }

}
