package practise.chapter8linkedlist

import org.scalatest.FunSuite

class Exercise1CollectionMethods extends FunSuite {
  //Our own implementation of a linked list
  abstract class AbstractLinkedList {
  }

  case object EmptyList extends AbstractLinkedList
  case class LinkedList(value: String, tail: AbstractLinkedList) extends AbstractLinkedList

  object Exercise {
    //hints: pattern matching and recursion
    //maybe http://alvinalexander.com/scala/scala-unreachable-code-due-to-variable-pattern-message
    def listContains(list: AbstractLinkedList, value: String): Boolean = {
      list match {
        case EmptyList => false
        case linkedList: LinkedList => linkedList.value === value || listContains(linkedList.tail, value)
      }
    }

    def map(list: AbstractLinkedList, function: String => String): AbstractLinkedList = {
      list match {
        case EmptyList => EmptyList
        case linkedList: LinkedList => LinkedList(function(linkedList.value), map(linkedList.tail, function))
      }
    }

    def flatMap(list: AbstractLinkedList, function: String => AbstractLinkedList): AbstractLinkedList = {
      list match {
        case EmptyList => EmptyList
        case input: LinkedList => {
          function(input.value) match {
            case EmptyList => EmptyList
            case result: LinkedList =>
              def chooseTail(recursiveResult: AbstractLinkedList): AbstractLinkedList = {
                findLastList(result) match {
                  case last: LinkedList if (last != result) => last.copy(last.value, recursiveResult)
                  case last: LinkedList => recursiveResult
                }
              }
              LinkedList(result.value, chooseTail(flatMap(input.tail, function)))
          }
        }
      }
    }

    def findLastList(list: AbstractLinkedList): LinkedList = {
      list match {
        case linkedList: LinkedList if (linkedList.tail === EmptyList) => linkedList
        case linkedList: LinkedList => findLastList(linkedList.tail)
      }
    }

    def addLists(list1: AbstractLinkedList, list2: AbstractLinkedList): AbstractLinkedList = {
      if (list2 === EmptyList)
        return list1
      list1 match {
        case EmptyList => addLists(list2, list1)
        case linkedList: LinkedList => LinkedList(linkedList.value, addLists(linkedList.tail, list2))
      }
    }
  }
  import Exercise._

  val list1 = LinkedList("1", EmptyList)
  val list123 = LinkedList("1", LinkedList("2", LinkedList("3", EmptyList)))

  test("listContains - emptyList") {
    assert(!listContains(EmptyList, "1"))
  }

  test("listContains - (1, 2)") {
    val list = LinkedList("1", LinkedList("2", EmptyList))
    assert(listContains(list, "1"))
    assert(listContains(list, "2"))
    assert(!listContains(list, "3"))
  }

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
    assert(addLists(EmptyList, list1) === list1)
  }

  test("addLists - list2 empty") {
    assert(addLists(list1, EmptyList) === list1)
  }

  test("addLists - 1234") {
    val list1 = LinkedList("1", LinkedList("2", EmptyList))
    val list2 = LinkedList("3", LinkedList("4", EmptyList))
    val expected = LinkedList("1", LinkedList("2", LinkedList("3", LinkedList("4", EmptyList))))
    assert(addLists(list1, list2) === expected)
  }

}