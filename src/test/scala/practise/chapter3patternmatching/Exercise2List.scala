package practise.chapter3patternmatching

import org.scalatest.FunSuite

class Exercise2List extends FunSuite {
  object Exercise {
  }
  //startAnswer
  object Answer {
    //try to match with ::
    def firstElement(list: List[Int]) = list match {
      case first :: _ => first
    }

    def first2Elements(list: List[Int]) = list match {
      case first :: second :: _ => List(first, second)
    }

    def matchList(list: List[Any]): String = list match {
      case Nil => "empty"
      case _ if list.size > 10 => "a lot of elements"
      case (_ : Int) :: _ => "starts with a number"
      case (s : String) :: _ => s"starts with $s"
    }
  }
  import Answer._
  //endAnswer

  test("firstElement") {
    assert(firstElement(1 :: Nil) === 1)
    assert(firstElement(1 :: 2 :: 3 :: Nil) === 1)
    assert(firstElement(List(5, 6, 7, 8)) === 5)
  }

  test("first2Elements") {
    assert(first2Elements(1 :: 2 :: Nil) === List(1, 2))
    assert(first2Elements(1 :: 2 :: 3 :: Nil) === List(1, 2))
    assert(first2Elements(List(5, 6, 7, 8)) === List(5, 6))
  }

  test("matchList") {
    assert(matchList(Nil) === "empty")
    assert(matchList(List(4)) === "starts with a number")
    assert(matchList(List(1, 2)) === "starts with a number")
    assert(matchList(List(6, 2, 2)) === "starts with a number")
    assert(matchList(List("a", 2, 3)) === "starts with a")
    assert(matchList(List("bla", 2)) === "starts with bla")
  }

  test("matchList with a lot of elements") {
    assert(matchList(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)) === "a lot of elements")
  }


}
