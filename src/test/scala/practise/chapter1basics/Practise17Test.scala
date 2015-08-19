package practise.chapter1basics

import org.scalatest.FunSuite

object Practise17 {
  //read: https://twitter.github.io/scala_school/basics2.html#fnobj
  def function1: Function1[Int, Int] = ???
  def listOfFunctions: List[Function1[Int, Int]] = ???

}

class Practise17Test extends FunSuite {
  import Practise17._

  test("function1") {
    assert(function1(0) === 1)
    assert(function1(1) === 2)
    assert(function1(2) === 3)
  }

  test("listOfFunctions") {
    assert(listOfFunctions.size === 3)
    assert(listOfFunctions.head(1) === 2)
    assert(listOfFunctions.head(2) === 3)
    assert(listOfFunctions.head(3) === 4)
    assert(listOfFunctions(1)(1) === 3)
    assert(listOfFunctions(1)(2) === 4)
    assert(listOfFunctions(1)(3) === 5)
  }

}
