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
  }
  //startAnswer
  object Answer {
    def emptyList: List[Any] = Nil

    def twoThree: List[Any] = List(2, 3)

    def oneTwoThree: List[Any] = 1 :: twoThree
  }
  import Answer._
  //endAnswer

  test("lists") {
    assert(emptyList === Nil)
    assert(twoThree === List(2, 3))
    assert(oneTwoThree === List(1, 2, 3))
  }

}
