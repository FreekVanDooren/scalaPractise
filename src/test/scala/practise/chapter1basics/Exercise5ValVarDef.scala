package practise.chapter1basics

import org.scalatest.FunSuite

//Lazy val will be evaluated once, when it's needed for the first time
//Here we see the differences between val, lazy val, var and def.
class Exercise5ValVarDef extends FunSuite {
  object Exercise {
    var counter = 1

    val valOne = counter
    lazy val lazyA = counter
    lazy val lazyB = counter
    var varOne = counter
    def defOne = counter

    val test1 = valOne
    val answer1 = ???

    val test2 = lazyA
    val answer2 = ???

    val test3 = varOne
    val answer3 = ???

    val test4 = defOne
    val answer4 = ???

    counter = 2

    val test5 = valOne
    val answer5 = ???

    val test6 = lazyA
    val answer6 = ???

    val test7 = varOne
    val answer7 = ???

    val test8 = defOne
    val answer8 = ???

    val test9 = lazyB
    val answer9 = ???

  }
  import Exercise._

  test("test1") {
    assert(test1 === answer1)
  }

  test("test2") {
    assert(test2 === answer2)
  }

  test("test3") {
    assert(test3 === answer3)
  }

  test("test4") {
    assert(test4 === answer4)
  }

  test("test5") {
    assert(test5 === answer5)
  }

  test("test6") {
    assert(test6 === answer6)
  }

  test("test7") {
    assert(test7 === answer7)
  }

  test("test8") {
    assert(test8 === answer8)
  }

  test("test9") {
    assert(test9 === answer9)
  }
}
