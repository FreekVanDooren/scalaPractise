package practise.chapter3patternmatching

import org.scalatest.FunSuite

class Exercise2List extends FunSuite {
  object Exercise {
  }
  //startAnswer
  object Answer {
    //hint: match with ::
    def first2Elements(list: List[Int]) = list match {
      case first :: second :: _ => List(first, second)
    }
  }
  import Answer._
  //endAnswer

  test("first2Elements") {
    assert(first2Elements(1 :: 2 :: Nil) === List(1, 2))
    assert(first2Elements(1 :: 2 :: 3 :: Nil) === List(1, 2))
    assert(first2Elements(List(5, 6, 7, 8)) === List(5, 6))
  }


}
