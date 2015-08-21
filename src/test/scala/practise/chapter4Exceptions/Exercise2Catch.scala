package practise.chapter4Exceptions

import org.scalatest.FunSuite

//TODO
class Exercise2Catch extends FunSuite {
  //100 is pretty high, should be close enough to infinity
  val infinity: Int = 100

  object Exercise {
  }
  //startAnswer
  object Answer {

    //calculates a/b
    //Will return infinity instead of ArithmeticException
    def divide(a: Int, b: Int): Int = {
      try {
        a / b
      } catch {
        case _: ArithmeticException => infinity
      }
    }
  }
  import Answer._
  //endAnswer

  test("divide - happy") {
    assert(divide(1, 1) === 1)
    assert(divide(6, 3) === 2)
  }

  test("divide - by zero") {
    assert(divide(1, 0) === infinity)
  }


}
