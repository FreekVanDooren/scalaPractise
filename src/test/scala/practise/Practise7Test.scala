package practise

import org.scalatest.FunSuite
import practise.chapter3flatmap.Practise7
import Practise7._

class Practise7Test extends FunSuite {

  test("combinationsFlatMap") {
    testFunction(combinationsFlatMap)
  }

  test("combinationsFor") {
    testFunction(combinationsFor)
  }

  def testFunction(function: (List[String], List[Int]) => List[String]) = {
    assert(function(List("a", "b", "c"), List(1, 2, 3)) === List("a1", "a2", "a3", "b1", "b2", "b3", "c1", "c2", "c3"))
  }

}
