package practise.chapter1basics

import org.scalatest.FunSuite

//Read https://twitter.github.io/scala_school/basics.html#functions
//def creates a function, that will be calculated when run
class Exercise4Def extends FunSuite {
  object Exercise {
    //Add one to x
    def addOne(x: Int): Int = ???
  }
  //startAnswer
  object Answer {
    def addOne(x: Int): Int = x + 1
  }
  import Answer._
  //endAnswer

  test("addOne - 1 + 1 = 2") {
    assert(addOne(1) === 2)
  }

  test("addOne - 10 + 1 = 11") {
    assert(addOne(10) === 11)
  }

}
