package practise.chapter4Exceptions

import org.scalatest.FunSuite

//TODO
//read http://www.tutorialspoint.com/scala/scala_exception_handling.htm
class Exercise1Throw extends FunSuite {
  class TooHighException extends Exception

  object Exercise {
  }
  //startAnswer
  object Answer {

    //throws a TooHighException if i>10
    def double(i: Int): Int = {
      if (i > 10) throw new TooHighException
      2 * i
    }
  }
  import Answer._
  //endAnswer

  test("double - low") {
    assert(double(0) === 0)
    assert(double(3) === 6)
  }

  test("double - too high") {
    intercept[TooHighException] {
      double(13)
    }
  }


}
