package practise

import org.scalatest.FunSuite
import practise.chapter4patternmatching.Practise18
import Practise18._

class Practise18Test extends FunSuite {
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
