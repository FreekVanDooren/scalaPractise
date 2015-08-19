package practise.chapter6linkedlist

import org.scalatest.FunSuite

object Practise9 {
  //Our own implementation of a linked list
  abstract class AbstractLinkedList
  case object EmptyList extends AbstractLinkedList
  case class LinkedList(value: String, tail: AbstractLinkedList) extends AbstractLinkedList

  //hints: pattern matching and recursion
  def listContains(l: AbstractLinkedList, x: String): Boolean = ???

}

class Practise9Test extends FunSuite {
  import Practise9._

  test("listContains - emptyList") {
    assert(!listContains(EmptyList, "1"))
  }

  test("listContains - (1, 2)") {
    val list = LinkedList("1", LinkedList("2", EmptyList))
    assert(listContains(list, "1"))
    assert(listContains(list, "2"))
    assert(!listContains(list, "3"))
  }

}
