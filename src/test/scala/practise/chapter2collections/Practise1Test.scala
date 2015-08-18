package practise.chapter2collections

object Practise1 { //methods on lists
  //return all even numbers from the list
  def allEvenNumbers(list: List[Int]): List[Int] = ???
}

class Practise1Test extends org.scalatest.FunSuite {
  import Practise1._

  test("allEvenNumbers - none") {
    assert(allEvenNumbers(List()) === List())
  }

  test("allEvenNumbers - 1") {
    assert(allEvenNumbers(List(1)) === List())
  }

  test("allEvenNumbers - 2") {
    assert(allEvenNumbers(List(2)) === List(2))
  }

  test("allEvenNumbers - many") {
    assert(allEvenNumbers(List(1, 2, 3, 4, 5, 6)) === List(2, 4, 6))
  }

}
