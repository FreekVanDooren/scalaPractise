package practise

import org.scalatest.FunSuite
import practise.chapter2collections.Practise3
import Practise3._

class Practise3Test extends FunSuite {

  test("addToAll") {
    assert(addToAll(List(1, 2, 3), 1) === List(2, 3, 4))
    assert(addToAll(List(1, 2, 3), 3) === List(4, 5, 6))
  }

  test("findNegativeNumbers") {
    assert(findNegativeNumbers(List(-1, 1, -5)) === List(-1, -5))
    assert(findNegativeNumbers(List(1, -5, -6)) === List(-5, -6))
  }

  test("firstPositiveNumber") {
    assert(firstPositiveNumber(List(1, 2, 3)) === Some(1)) //Notice that it wraps the result in an option
    assert(firstPositiveNumber(List(-1, -2)) === None)     //Because it may be none
    assert(firstPositiveNumber(List(-1, -2, 4)) === Some(4))
  }

  test("sum") {
    assert(sum(List(1, 2, 3)) === 6)
    assert(sum(List(5, 5)) === 10)
  }

  test("sumAll") {
    assert(sumAll(List(List(1, 2, 3), List(5, 5))) === 16)
    assert(sumAll(List(List(1, 2, 3), List(1, 2, 3))) === 12)
  }

  test("twiceList") {
    assert(twiceList(List(1, 2, 3)) === List(1, 1, 2, 2, 3, 3))
  }

}
