package practise.chapter8linkedlist

import org.scalatest.FunSuite

class Exercise2AtIndex extends FunSuite {
  object Exercise {
    class IndexOutOfBoundsException extends Exception
    abstract class AbstractLinkedList {
      //returns the value at 'index', may throw an IndexOutOfBoundsException
      def atIndex(index: Int): String = ???

      //Here we make some syntactic sugar on our list. so we can call list(0) to get the first element
      //apply is a special method and can be called easier, see test
      def apply(index: Int): String = ???
    }
    case object EmptyList extends AbstractLinkedList
    case class LinkedList(value: String, tail: AbstractLinkedList) extends AbstractLinkedList
  }
  import Exercise._

  val list123 = LinkedList("1", LinkedList("2", LinkedList("3", EmptyList)))

  test("atIndex - on EmptyList") {
    intercept[IndexOutOfBoundsException] {
      EmptyList.atIndex(0)
    }
  }

  test("atIndex - 0") {
    assert(list123.atIndex(0) === "1")
  }

  test("atIndex - 1") {
    assert(list123.atIndex(1) === "2")
  }

  test("atIndex - 2") {
    assert(list123.atIndex(2) === "3")
  }

  test("atIndex - 3") {
    intercept[IndexOutOfBoundsException] {
      EmptyList.atIndex(3)
    }
  }


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