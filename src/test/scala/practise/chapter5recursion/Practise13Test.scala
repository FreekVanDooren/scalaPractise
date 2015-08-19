package practise.chapter5recursion

import org.scalatest.FunSuite

object Practise13 {
  //Given a non-negative int n, return the sum of its digits.
  //hint: modulo (%) and recursion

  def sumDigits(x: Int): Int = ???

}

class Practise13Test extends FunSuite {
  import Practise13._

  test("sumDigits - 0") {
    assert(sumDigits(0) === 0)
  }

  test("sumDigits - 1") {
    assert(sumDigits(1) === 1)
  }

  test("sumDigits - 11") {
    assert(sumDigits(11) === 2)
  }

  test("sumDigits - 123") {
    assert(sumDigits(123) === 6)
  }

  test("sumDigits - 99") {
    assert(sumDigits(99) === 18)
  }
}
