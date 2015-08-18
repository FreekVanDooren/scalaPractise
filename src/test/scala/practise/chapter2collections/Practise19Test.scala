package practise.chapter2collections

import org.scalatest.FunSuite

object Practise19 { //creating Lists
  //read: http://www.tutorialspoint.com/scala/scala_lists.htm

  def emptyList = ???

  //create a list with List(1, 2, 3
  def twoThree = ???

  //add a one at the start of the list using ::
  def oneTwoThree = ???

  //You can also use :: for pattern matching
  def matchList(list: List[Any]): String = ???

}

class Practise19Test extends FunSuite {
  import Practise19._

  //TODO
//  test("lists") {
//    assert(emptyList === Nil)
//    assert(twoThree === List(2, 3))
//    assert(oneTwoThree === List(1, 2, 3))
//  }

  //TODO: verhuizen naar pattern matching
  test("matchList") {
    assert(matchList(Nil) === "empty")
    assert(matchList(List(1, 2)) === "starts with a number")
    assert(matchList(List(6, 2)) === "starts with a number")
    assert(matchList(List("a", 2)) === "starts with a")
    assert(matchList(List("bla", 2)) === "starts with bla")
  }


}
