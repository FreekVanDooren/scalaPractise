package practise.chapter1basics

import org.scalatest.FunSuite

object Practise4 {
  //create a counter that always returns one more than the last time
  class Counter {
    def oneMore(): Int = ???
  }

}

class Practise4Test extends FunSuite {
  import Practise4._

  test("Counter") {
    val c = new Counter
    assert(c.oneMore() === 1)
    assert(c.oneMore() === 2)
    assert(c.oneMore() === 3)
    assert(c.oneMore() === 4)
  }

}
