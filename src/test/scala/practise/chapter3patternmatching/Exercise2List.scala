package practise.chapter3patternmatching

import org.scalatest.FunSuite

class Exercise2List extends FunSuite {
  case class Animal(sound: String)
  object dog("woof") extends Animal
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
      case _ : Integer :: _ => "starts with a number"
      case s : String :: _ => s"starts with $s"
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
    assert(matchList(List(1, 2)) === "starts with a number")
    assert(matchList(List(6, 2)) === "starts with a number")
    assert(matchList(List("a", 2)) === "starts with a")
    assert(matchList(List("bla", 2)) === "starts with bla")
  }


}
