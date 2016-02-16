package practise.chapter8linkedlist

import org.scalatest.FunSuite

class Exercise3Create extends FunSuite {
  abstract class AbstractLinkedList
  case object EmptyList extends AbstractLinkedList
  case class LinkedList(value: String, tail: AbstractLinkedList) extends AbstractLinkedList

  object Exercise {
    //We'll make an easy way to create LinkedList
    //We want to be able to create one like createLinkedList(1, 2, 3)
    //of course with an arbitrary number of parameters
    //hint: http://www.tutorialspoint.com/scala/functions_variable_arguments.htm
    def createLinkedList(values: String*): AbstractLinkedList = ???
  }
  import Exercise._

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