package practise.chapter5recursion

import org.scalatest.FunSuite

class Exercise1SumDigits extends FunSuite {
  object Exercise {
    //Given a non-negative int n, return the sum of its digits.
    //hint: modulo (%) and recursion
    //As always with recursion, think about the endcase(s) and decide if you want to work forward or backward.
    def sumDigits(x: Int): Int = ???
  }
  //startAnswer
  object Answer {
    def sumDigits(x: Int): Int = {
      if (x == 0) 0
      else x % 10 + sumDigits(x / 10)
    }
  }
  import Answer._
  //endAnswer

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
