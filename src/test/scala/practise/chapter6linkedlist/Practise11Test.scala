package practise.chapter6linkedlist

import org.scalatest.FunSuite

object Practise11 {
  //Here we make some syntactic sugar on our list. so we can call list(0) to get the first element
  class IndexOutOfBoundsException extends Exception
  abstract class AbstractLinkedList {
    //apply is a special method and can be called easier, see test
    def apply(index: Int): String = ???
  }
  case object EmptyList extends AbstractLinkedList
  case class LinkedList(value: String, tail: AbstractLinkedList) extends AbstractLinkedList


}

class Practise11Test extends FunSuite {
  import Practise11._

  val list123 = LinkedList("1", LinkedList("2", LinkedList("3", EmptyList)))

  test("apply - on EmptyList") {
    intercept[IndexOutOfBoundsException] {
      EmptyList(0)
    }
  }

  test("apply - 0") {
    assert(list123(0) === "1")
  }

  test("apply - 1") {
    assert(list123(1) === "2")
  }

  test("apply - 2") {
    assert(list123(2) === "3")
  }

  test("apply - 3") {
    intercept[IndexOutOfBoundsException] {
      EmptyList(3)
    }
  }



}
