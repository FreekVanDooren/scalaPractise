package practise

object Practise19 {
  //read: http://www.tutorialspoint.com/scala/scala_lists.htm

  def emptyList = Nil

  //create a list with List(1, 2, 3
  def twoThree = List(2, 3)

  //add a one at the start of the list using ::
  def oneTwoThree = 1 :: twoThree

  //You can also use :: for pattern matching
  def matchList(list: List[Any]): String = list match {
    case Nil => "empty"
    case (x: Int) :: _ => "starts with a number"
    case x :: _ => "starts with " + x
  }
  
}
