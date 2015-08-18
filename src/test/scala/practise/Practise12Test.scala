package practise

import org.scalatest.FunSuite
import practise.chapter6linkedlist.Practise12
import Practise12._

class Practise12Test extends FunSuite {
  test("EmptyList") {
    assert(createLinkedList() === EmptyList)
  }

  test("1") {
    assert(createLinkedList("1") === LinkedList("1", EmptyList))
  }

  test("12") {
    assert(createLinkedList("1", "2") === LinkedList("1", LinkedList("2", EmptyList)))
  }

  test("123") {
    val list123: LinkedList = LinkedList("1", LinkedList("2", LinkedList("3", EmptyList)))
    assert(createLinkedList("1", "2", "3") === list123)
  }
}
