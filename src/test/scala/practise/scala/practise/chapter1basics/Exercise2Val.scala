package practise.chapter1basics

import org.scalatest.FunSuite

//Read https://twitter.github.io/scala_school/basics.html up to variables
//val creates an immutable variable
class Exercise2Val extends FunSuite {
  object Exercise {
    val one: Int = 1

    //Scala will determine the type of a variable if you don't explicitly mention it. Try this instead:
    //val one = 1

    //You can't reassign an immutable variable. This won't compile.
    //one = 2
  }
  import Exercise._

  test("one is 1") {
    assert(one === 1)
  }

  test("one is an Int") {
    assert(one.isInstanceOf[Int])
  }
}