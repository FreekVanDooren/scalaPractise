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
  }
  import Answer._
  //endAnswer

  test("firstElement") {
    assert(first2Elements(1 :: Nil) === 1)
    assert(first2Elements(1 :: 2 :: 3 :: Nil) === 1)
    assert(first2Elements(List(5, 6, 7, 8)) === 5)
  }

  test("first2Elements") {
    assert(first2Elements(1 :: 2 :: Nil) === List(1, 2))
    assert(first2Elements(1 :: 2 :: 3 :: Nil) === List(1, 2))
    assert(first2Elements(List(5, 6, 7, 8)) === List(5, 6))
  }


}
