package practise.chapter8linkedlist

import org.scalatest.FunSuite

class Exercise4Print extends FunSuite {
  //Notice that the type of value is now Any, so it can be anything, even another LinkedList
  abstract class AbstractLinkedList
  case object EmptyList extends AbstractLinkedList
  case class LinkedList(value: Any, tail: AbstractLinkedList) extends AbstractLinkedList

  object Exercise {
    def printList(list: AbstractLinkedList): String = {
      list match {
        case EmptyList => "[]"
        case LinkedList(value: String, EmptyList) => "[" + value + "]"
        case LinkedList(value: String, tail: LinkedList) => "[" + value + "," + ((x: String) => x.substring(1, x.length))(printList(tail))
        case LinkedList(EmptyList, EmptyList) => "[[]]"
        case LinkedList(value: LinkedList, EmptyList) => "[" + printList(value) +"]"
        case LinkedList(value: LinkedList, tail: LinkedList) => "[" + printList(value) + "," + ((x: String) => x.substring(1, x.length - 1))(printList(tail)) + "]"
      }
    }
  }
  import Exercise._

  test("printList - []") {
    assert(printList(EmptyList) === "[]")
  }

  test("printList - [1]") {
    assert(printList(LinkedList("1", EmptyList)) === "[1]")
  }

  test("printList - [1,2]") {
    assert(printList(LinkedList("1", LinkedList("2", EmptyList))) === "[1,2]")
  }

  test("printList - [1,2,3]") {
    assert(printList(LinkedList("1", LinkedList("2", LinkedList("3", EmptyList)))) === "[1,2,3]")
  }

  test("printList - [[]]") {
    assert(printList(LinkedList(EmptyList, EmptyList)) === "[[]]")
  }

  test("printList - [[a1,a2],[b1,b2]]") {
    val listA = LinkedList("a1", LinkedList("a2", EmptyList))
    val listB = LinkedList("b1", LinkedList("b2", EmptyList))
    assert(printList(LinkedList(listA, LinkedList(listB, EmptyList))) === "[[a1,a2],[b1,b2]]")
  }

  test("printList - [[[[1]]]]") {
    assert(printList(LinkedList(LinkedList(LinkedList(LinkedList("1", EmptyList), EmptyList), EmptyList), EmptyList)) === "[[[[1]]]]")
  }

}