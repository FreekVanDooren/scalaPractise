package practise.chapter7recursion

import org.scalatest.FunSuite

class Exercise1SumDigits extends FunSuite {
  object Exercise {
    //Given a non-negative int n, return the sum of its digits.
    //hint: modulo (%) and recursion
    //As always with recursion, think about the endcase(s) and decide if you want to work forward or backward.
    def sumDigits(x: Int): Int = ???
  }
  import Exercise._

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