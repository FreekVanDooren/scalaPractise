package practise.chapter4Exceptions

import org.scalatest.FunSuite

class Exercise2Catch extends FunSuite {
  //100 is pretty high, this should be close enough to infinity
  val infinity: Int = 100

  object Exercise {
    //calculates a/b
    //Will return infinity instead of ArithmeticException
    def divide(a: Int, b: Int): Int = ???
  }
  import Exercise._

  test("divide - happy") {
    assert(divide(1, 1) === 1)
    assert(divide(6, 3) === 2)
  }

  test("divide - by zero") {
    assert(divide(1, 0) === infinity)
  }


}