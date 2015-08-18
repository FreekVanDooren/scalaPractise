package practise

import org.scalatest.FunSuite
import practise.chapter6linkedlist.Practise17
import Practise17._

class Practise17Test extends FunSuite {
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
