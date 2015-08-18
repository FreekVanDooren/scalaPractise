package practise

import org.scalatest.FunSuite
import practise.chapter5recursion.Practise13
import Practise13._

class Practise13Test extends FunSuite {
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
