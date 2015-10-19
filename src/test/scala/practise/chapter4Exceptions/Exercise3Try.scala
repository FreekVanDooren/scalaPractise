package practise.chapter4Exceptions

import org.scalatest.FunSuite

import scala.util.{Failure, Success, Try}

//Here we use the Try class
//read http://danielwestheide.com/blog/2012/12/26/the-neophytes-guide-to-scala-part-6-error-handling-with-try.html
class Exercise3Try extends FunSuite {
  //method that may throw an exception
  class TooHighException extends Exception
  def double(i: Int): Int = {
    if (i > 10) throw new TooHighException
    2 * i
  }

  object Exercise {
    def tryDouble(i: Int): Try[Int] = ???
  }
  import Exercise._

  test("tryDouble") {
    assert(tryDouble(1).isSuccess)
    assert(tryDouble(1) === Success(2))
    assert(tryDouble(11).isFailure)
  }


}