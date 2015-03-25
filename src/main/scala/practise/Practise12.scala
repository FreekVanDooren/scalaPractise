package practise

object Practise12 {
  abstract class AbstractLinkedList
  case object EmptyList extends AbstractLinkedList
  case class LinkedList(value: String, tail: AbstractLinkedList) extends AbstractLinkedList

  //We'll make an easy way to create LinkedList
  //We want to be able to create one like createLinkedList(1, 2, 3)
  //of course with an arbitrary number of parameters
  //hint: http://www.tutorialspoint.com/scala/functions_variable_arguments.htm
  def createLinkedList(values: String*): AbstractLinkedList = ???

}
