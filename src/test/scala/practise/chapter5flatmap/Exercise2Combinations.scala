package practise.chapter5flatmap

import org.scalatest.FunSuite


class Exercise2Combinations extends FunSuite {
  object Exercise {
    //a helper function for combinationsFlatMap
    def combinationsForOneLetter(letter: String, numbers: List[Int]): List[String] = ???

    //Create a list of all the combinations of letters and numbers (a1, a2, a3, b1, b2, .....)
    def combinationsFlatMap(letters: List[String], numbers: List[Int]): List[String] = ???

    //Use for and yield here.
    //Should do the same as combinationsFlatMap
    def combinationsFor(letters: List[String], numbers: List[Int]): List[String] = ???
  }
  //startAnswer
  object Answer {
  }
  import Answer._
  //endAnswer

  test("combinationsForOneLetter") {
    assert(combinationsForOneLetter("z", List()) === List())
    assert(combinationsForOneLetter("z", List(1, 2, 3)) === List("z1", "z2", "z3"))
  }

  test("combinationsFlatMap") {
    testFunction(combinationsFlatMap)
  }

  test("combinationsFor") {
    testFunction(combinationsFor)
  }

  def testFunction(function: (List[String], List[Int]) => List[String]) = {
    assert(function(List(), List(1, 2, 3)) === List())
    assert(function(List("a", "b", "c"), List()) === List())
    assert(function(List("a"), List(1, 2, 3)) === List("a1", "a2", "a3"))
    assert(function(List("a", "b", "c"), List(1)) === List("a1", "b1", "c1"))
    assert(function(List("a", "b", "c"), List(1, 2, 3)) === List("a1", "a2", "a3", "b1", "b2", "b3", "c1", "c2", "c3"))
  }

}
