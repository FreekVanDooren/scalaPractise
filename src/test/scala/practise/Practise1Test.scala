package practise

import practise.Practise1._

class Practise1Test extends org.scalatest.FunSuite {
  test("allEvenNumbers - none") {
    assert(allEvenNumbers(List()) === List())
  }

  test("allEvenNumbers - 1") {
    assert(allEvenNumbers(List(1)) === List())
  }

  test("allEvenNumbers - 2") {
    assert(allEvenNumbers(List(2)) === List(2))
  }

  test("allEvenNumbers - many") {
    assert(allEvenNumbers(List(1, 2, 3, 4, 5, 6)) === List(2, 4, 6))
  }

}
