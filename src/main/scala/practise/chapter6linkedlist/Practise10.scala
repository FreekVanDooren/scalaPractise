package practise.chapter6linkedlist

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
