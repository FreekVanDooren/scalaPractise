package practise

object Practise9 {
  //Our own implementation of a linked list
  abstract class AbstractLinkedList
  case object EmptyList extends AbstractLinkedList
  case class LinkedList(value: String, tail: AbstractLinkedList) extends AbstractLinkedList

  //hints: pattern matching and recursion
  def listContains(l: AbstractLinkedList, x: String): Boolean = ???

}
