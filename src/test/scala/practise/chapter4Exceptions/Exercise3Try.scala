package practise.chapter4Exceptions

import org.scalatest.FunSuite

//TODO
class Exercise3Try extends FunSuite {
  //method that may throw an exception
  class TooHighException extends Exception
  def double(i: Int): Int = {
    if (i > 10) throw new TooHighException
    2 * i
  }

  object Exercise {
    //hint: flatMap
    def parseInts(input: List[String]): List[Int] = ???
  }
  //startAnswer
  object Answer {
    //hint: flatMap
//    def parseInts(input: List[String]): List[Int] = input.flatMap(parseInt)
  }
  import Answer._
  //endAnswer

//  test("parseInts - None") {
//    assert(parseInts(Nil) === Nil)
//  }
//
//  test("parseInts - 1, 2, 3") {
//    assert(parseInts(List("1", "2", "3")) === List(1, 2, 3))
//  }
//
//  test("parseInts - a, 1, w") {
//    assert(parseInts(List("a", "1", "w")) === List(1))
//  }


}
