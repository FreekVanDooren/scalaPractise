package practise.chapter1basics

import org.scalatest.FunSuite

//var creates an mutable variable
class Exercise3Var extends FunSuite {
  object Exercise {
    var count = 1
    count = ???
  }
  import Exercise._

  test("count = 2") {
   assert(count === 2)
  }

  test("count is an Int") {
   assert(count.isInstanceOf[Int])
  }
}