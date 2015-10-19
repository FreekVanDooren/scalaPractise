package practise.chapter1basics

import org.scalatest.FunSuite

//read: https://twitter.github.io/scala_school/basics2.html#object
//and https://twitter.github.io/scala_school/basics2.html#fnobj
//Notice that functions have a type and we can treat them as objects
class Exercise8FunctionParameter extends FunSuite {
  object Exercise {
    def doTwice(function: => Unit) = ???
  }
  import Exercise._

  test("twice - anonymous method") {
    var x = 0
    def increase(): Unit = { x = x + 1 }

    doTwice { increase() }

    assert(x === 2)
  }

  test("twice - passing a method reference") {
    var x = 0
    def increase(): Unit = { x = x + 1 }

    doTwice(increase)

    assert(x === 2)
  }

}