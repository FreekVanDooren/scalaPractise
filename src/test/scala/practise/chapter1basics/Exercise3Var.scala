package practise.chapter1basics

import org.scalatest.FunSuite

//var creates an mutable variable
class Exercise3Var extends FunSuite {
  object Exercise {
    var count = 1
    count = ???
  }

  test("count = 2") {
   assert(Exercise.count === 2)
  }

  test("count is an Int") {
   assert(Exercise.count.isInstanceOf[Int])
  }
}
