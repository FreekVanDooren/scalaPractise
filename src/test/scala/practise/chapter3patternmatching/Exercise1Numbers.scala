package practise.chapter3patternmatching

import org.scalatest.FunSuite

//read https://twitter.github.io/scala_school/basics2.html#match
class Exercise1Numbers extends FunSuite {
  object Exercise {
    def matchInt(number: Int): String = ???

    def matchNumber(number: Any): String = ???
  }
  //startAnswer
  object Answer {
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
  import Answer._
  //endAnswer

  test("matchInt - match on value") {
    assert(matchInt(1) === "one")
    assert(matchInt(2) === "two")
  }

  test("matchInt - match with if") {
    assert(matchInt(5) === "few")
    assert(matchInt(7) === "few")
    assert(matchInt(11) === "many")
    assert(matchInt(101) === "many")
  }

  test("matchNumber") {
    assert(matchNumber(4) === "an Integer")
    assert(matchNumber(0.53412) === "a Double")
    assert(matchNumber(9999) === "a big Integer")
    assert(matchNumber("bla") === "not a number")
  }


}
