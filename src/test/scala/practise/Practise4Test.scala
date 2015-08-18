package practise

import org.scalatest.FunSuite
import practise.chapter1basics.Practise4
import Practise4._

class Practise4Test extends FunSuite {

  test("Counter") {
    val c = new Counter
    assert(c.oneMore() === 1)
    assert(c.oneMore() === 2)
    assert(c.oneMore() === 3)
    assert(c.oneMore() === 4)
  }

}
