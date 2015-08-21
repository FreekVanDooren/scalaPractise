package practise.chapter3flatmap

import org.scalatest.FunSuite

import scala.util.Try

class Exercise5OptionsAndLists extends FunSuite {
  object Exercise {
  }
  //startAnswer
  object Answer {
    def parseInt(s: String) = Try(Some(Integer.parseInt(s))).getOrElse(None)

    //hint: flatMap
    def parseInts(input: List[String]): List[Int] = input.flatMap(parseInt)
  }
  import Answer._
  //endAnswer

  test("parseInts - None") {
    assert(parseInts(Nil) === Nil)
  }

  test("parseInts - 1, 2, 3") {
    assert(parseInts(List("1", "2", "3")) === List(1, 2, 3))
  }

  test("parseInts - a, 1, w") {
    assert(parseInts(List("a", "1", "w")) === List(1))
  }


}
