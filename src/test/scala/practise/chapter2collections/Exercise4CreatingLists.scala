package practise.chapter2collections

import org.scalatest.FunSuite

//creating Lists
//read: http://www.tutorialspoint.com/scala/scala_lists.htm
class Exercise4CreatingLists extends FunSuite {
  object Exercise {
    def emptyList: List[Any] = ???

    def twoThree: List[Any] = ???

    //add a one at the start of twoThree using ::
    def oneTwoThree: List[Any] = ???

    //You can also use :: for pattern matching
    def matchList(list: List[Any]): String = ???
  }
  import Exercise._

  test("lists") {
    assert(emptyList === Nil)
    assert(twoThree === List(2, 3))
    assert(oneTwoThree === List(1, 2, 3))
  }

  //TODO: verhuizen naar pattern matching
  test("matchList") {
    assert(matchList(Nil) === "empty")
    assert(matchList(List(1, 2)) === "starts with a number")
    assert(matchList(List(6, 2)) === "starts with a number")
    assert(matchList(List("a", 2)) === "starts with a")
    assert(matchList(List("bla", 2)) === "starts with bla")
  }


}
