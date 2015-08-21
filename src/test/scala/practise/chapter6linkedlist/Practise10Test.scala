package practise.chapter6linkedlist

import org.scalatest.FunSuite

object Practise10 {
  //Our own implementation of a linked list
  abstract class AbstractLinkedList
  case object EmptyList extends AbstractLinkedList
  case class LinkedList(value: String, tail: AbstractLinkedList) extends AbstractLinkedList

  //hint: recursion
  def map(l: AbstractLinkedList, function: String => String): AbstractLinkedList = ???

  def addLists(list1: AbstractLinkedList, list2: AbstractLinkedList): AbstractLinkedList = ???

  def flatMap(l: AbstractLinkedList, function: String => AbstractLinkedList): AbstractLinkedList = ???

}

class Practise10Test extends FunSuite {
  import Practise10._

  val list1 = LinkedList("1", EmptyList)
  val list123 = LinkedList("1", LinkedList("2", LinkedList("3", EmptyList)))

  test("map - empty") {
    assert(map(EmptyList, { s => s }) === EmptyList)
  }

  test("map - don't change anything") {
    assert(map(list123, { s => s }) === list123)
  }

  test("map - double") {
    val expected = LinkedList("11", LinkedList("22", LinkedList("33", EmptyList)))
    assert(map(list123, { s => s + s }) === expected)
  }

  test("flatMap - empty") {
    assert(flatMap(EmptyList, { s => list1 }) === EmptyList)
  }

  test("flatMap - map everything to EmptyList") {
    assert(flatMap(list123, { s => EmptyList }) === EmptyList)
  }

  test("flatMap - don't change anything") {
    assert(flatMap(list123, { LinkedList(_, EmptyList) }) === list123)
  }

  test("flatMap - double") {
    val expected = LinkedList("1", LinkedList("1", LinkedList("2", LinkedList("2", LinkedList("3", LinkedList("3", EmptyList))))))
    assert(flatMap(list123, { s => LinkedList(s, LinkedList(s, EmptyList)) }) === expected)
  }

  test("addLists - empty") {
    assert(addLists(EmptyList, EmptyList) === EmptyList)
  }

  test("addLists - list1 empty") {
    assert(addLists(EmptyList, EmptyList) === EmptyList)
  }

  test("addLists - list2 empty") {
    assert(addLists(EmptyList, EmptyList) === EmptyList)
  }

  test("addLists - 1234") {
    val list1 = LinkedList("1", LinkedList("2", EmptyList))
    val list2 = LinkedList("3", LinkedList("4", EmptyList))
    val expected = LinkedList("1", LinkedList("2", LinkedList("3", LinkedList("4", EmptyList))))
    assert(addLists(list1, list2) === expected)
  }

}