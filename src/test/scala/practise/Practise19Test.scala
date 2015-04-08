package practise

import org.scalatest.FunSuite
import practise.Practise19._

class Practise19Test extends FunSuite {
  test("lists") {
    assert(emptyList === Nil)
    assert(twoThree === List(2, 3))
    assert(oneTwoThree === List(1, 2, 3))
  }

  test("matchList") {
    assert(matchList(Nil) === "empty")
    assert(matchList(List(1, 2)) === "starts with a number")
    assert(matchList(List(6, 2)) === "starts with a number")
    assert(matchList(List("a", 2)) === "starts with a")
    assert(matchList(List("bla", 2)) === "starts with bla")
  }


}
