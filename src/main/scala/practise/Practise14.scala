package practise

object Practise14 {
  //Now the elements may also be lists
  abstract class AbstractLinkedList
  case object EmptyList extends AbstractLinkedList
  case class LinkedList(value: Any, tail: AbstractLinkedList) extends AbstractLinkedList

  def printList(list: AbstractLinkedList): String = ???


}
