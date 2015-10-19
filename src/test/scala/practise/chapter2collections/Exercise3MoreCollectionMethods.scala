package practise.chapter2collections

import org.scalatest.FunSuite

//hint: https://twitter.github.io/scala_school/collections.html
//and http://www.scala-lang.org/api/2.10.3/index.html#scala.collection.immutable.List
class Exercise3MoreCollectionMethods extends FunSuite {
  object Exercise {
    //Add amount to all elements in list
    def addToAll(list: List[Int], amount: Int): List[Int] = ???

    //Return the subset of negative numbers
    def findNegativeNumbers(list: List[Int]): List[Int] = ???

    //Returns the first Positive number
    //Or None if there is no positive number
    def firstPositiveNumber(list: List[Int]): Option[Int] = ???

    //Add all elements in list together
    def sum(list: List[Int]): Int = ???

    //has a list of lists as input, sums up all elements
    def sumAll(list: List[List[Int]]): Int = ???

    //returns a list with all elements twice
    def twiceList(list: List[Int]): List[Int] = ???
  }
  import Exercise._

  test("addToAll") {
    assert(addToAll(List(1, 2, 3), 1) === List(2, 3, 4))
    assert(addToAll(List(1, 2, 3), 3) === List(4, 5, 6))
  }

  test("findNegativeNumbers") {
    assert(findNegativeNumbers(List(-1, 1, -5)) === List(-1, -5))
    assert(findNegativeNumbers(List(1, -5, -6)) === List(-5, -6))
  }

  test("firstPositiveNumber") {
    assert(firstPositiveNumber(List(1, 2, 3)) === Some(1))
    assert(firstPositiveNumber(List(-1, -2)) === None)
    assert(firstPositiveNumber(List(-1, -2, 4)) === Some(4))
  }

  test("sum") {
    assert(sum(List(1, 2, 3)) === 6)
    assert(sum(List(5, 5)) === 10)
  }

  test("sumAll") {
    assert(sumAll(List(List(1, 2, 3), List(5, 5))) === 16)
    assert(sumAll(List(List(1, 2, 3), List(1, 2, 3))) === 12)
  }

  test("twiceList") {
    assert(twiceList(List(1, 2, 3)) === List(1, 1, 2, 2, 3, 3))
  }

}