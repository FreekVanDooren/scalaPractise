package practise.chapter6flatmap

import org.scalatest.FunSuite

import scala.util.Try

class Exercise6OptionsAndLists extends FunSuite {
  //Parses an integer. Returns None if it cannot parse.
  def parseInt(s: String): Option[Int] = Try(Some(Integer.parseInt(s))).getOrElse(None)

  object Exercise {
    //hint: flatMap
    def parseInts(input: List[String]): List[Int] = ???
  }
  import Exercise._

  test("parseInts - None") {
    assert(parseInts(Nil) === Nil)
  }

  test("parseInts - 1, 2, 3") {
    assert(parseInts(List("1", "2", "3")) === List(1, 2, 3))
  }

  test("parseInts - a, 1, w") {
    assert(parseInts(List("a", "1", "w")) === List(1))
  }


}