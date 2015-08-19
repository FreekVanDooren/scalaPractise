package practise.chapter3flatmap

import org.scalatest.FunSuite

object Practise7 {
  //create a list of all the combinations of letters and numbers (a1, a2, a3, b1, b2, .....)

  //a helper function for combinationsFlatMap
  def combinationsForOneLetter(letter: String, numbers: List[Int]): List[String] = ???
  def combinationsFlatMap(letters: List[String], numbers: List[Int]): List[String] = ???

  //use for and yield here
  def combinationsFor(letters: List[String], numbers: List[Int]): List[String] = ???

}

class Practise7Test extends FunSuite {
  import Practise7._

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
