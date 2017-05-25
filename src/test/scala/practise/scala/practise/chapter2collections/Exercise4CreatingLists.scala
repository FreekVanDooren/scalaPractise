package practise.chapter2collections

import org.scalatest.FunSuite

//creating Lists
//read: http://www.tutorialspoint.com/scala/scala_lists.htm
class Exercise4CreatingLists extends FunSuite {
  object Exercise {
    def emptyList: List[Any] = List()

    def twoThree: List[Any] = List(2,3)

    //add a one at the start of twoThree using ::
    def oneTwoThree: List[Any] = (1 :: twoThree)

    //add all these lists together using :::
    def allTogether: List[Any] = twoThree ::: oneTwoThree
  }
  import Exercise._

  test("lists") {
    assert(emptyList === Nil)
    assert(twoThree === List(2, 3))
    assert(oneTwoThree === List(1, 2, 3))
    assert(allTogether === List(2, 3, 1, 2, 3))
  }

}