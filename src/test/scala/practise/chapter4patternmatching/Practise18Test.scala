package practise.chapter4patternmatching

import org.scalatest.FunSuite

object Practise18 {
  //read: https://twitter.github.io/scala_school/basics2.html#match
  def matchInt(number: Int): String = number match {
    case 1 => "one"
    case 2 => "two"
    case x if x < 10 => "few"
    case x if x > 10 => "many"
  }

  def matchNumber(number: Any): String = number match {
    case x: Integer if x > 10 => "a big Integer"
    case _: Integer => "an Integer"
    case _: Double => "a Double"
    case _ => "not a number"
  }

}

class Practise18Test extends FunSuite {
  import Practise18._

  test("matchInt") {
    assert(matchInt(1) === "one")
    assert(matchInt(2) === "two")
    assert(matchInt(100) === "many")
    assert(matchInt(101) === "many")
    assert(matchInt(5) === "few")
    assert(matchInt(7) === "few")
  }

  test("matchNumber") {
    assert(matchNumber(4) === "an Integer")
    assert(matchNumber(0.53412) === "a Double")
    assert(matchNumber(9999) === "a big Integer")
    assert(matchNumber("bla") === "not a number")
  }


}
