package practise.chapter1basics

import org.scalatest.FunSuite

//read the rest of https://twitter.github.io/scala_school/basics.html
//Create a counter that always returns one more than the last time
class Exercise6Counter extends FunSuite {
  object Exercise {
    class Counter(startWith: Int) {
      var counter = startWith

      def newNumber(): Int = {
        val result = counter
        counter += 1
        result
      }
    }
  }
  import Exercise._

  test("Counter starting with 0") {
    val c = new Counter(0)
    assert(c.newNumber() === 0)
    assert(c.newNumber() === 1)
    assert(c.newNumber() === 2)
    assert(c.newNumber() === 3)
    assert(c.newNumber() === 4)
  }

  test("Counter starting with 1") {
    val c = new Counter(1)
    assert(c.newNumber() === 1)
    assert(c.newNumber() === 2)
    assert(c.newNumber() === 3)
    assert(c.newNumber() === 4)
  }

}