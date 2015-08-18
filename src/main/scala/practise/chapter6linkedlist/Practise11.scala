package practise.chapter6linkedlist

object Practise11 {
  //Here we make some syntactic sugar on our list. so we can call list(0) to get the first element
  class IndexOutOfBoundsException extends Exception
  abstract class AbstractLinkedList {
    //apply is a special method and can be called easier, see test
    def apply(index: Int): String = ???
  }
  case object EmptyList extends AbstractLinkedList
  case class LinkedList(value: String, tail: AbstractLinkedList) extends AbstractLinkedList


}
