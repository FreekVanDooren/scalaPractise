package practise.chapter3patternmatching

import org.scalatest.FunSuite

//read https://twitter.github.io/scala_school/basics2.html#match
//and maybe https://kerflyn.wordpress.com/2011/02/14/playing-with-scalas-pattern-matching/
class Exercise1Numbers extends FunSuite {
  object Exercise {
    def matchInt(number: Int): String = {
      number match {
        case 1 => "one"
        case 2 => "two"
        case i if i <= 7 => "few"
        case i if i > 7 => "many"
      }
    }

    def matchNumber(number: Any): String = {
      number match {
        case i: Int if i <= 4 => "an Integer"
        case i: Double => "a Double"
        case i: Int if i > 4 => "a big Integer"
        case _ => "not a number"
      }
    }
  }
  import Exercise._

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