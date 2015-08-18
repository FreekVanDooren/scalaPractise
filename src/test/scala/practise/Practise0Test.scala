package practise

import org.scalatest.FunSuite
import practise.chapter1basics.Practise0
import Practise0._

class Practise0Test extends FunSuite {
  test("shouldReturnTrue - should return true") {
    assert(shouldReturnTrue() === true)
  }

  test("addOne - 1 + 1 = 2") {
    assert(addOne(1) === 2)
  }

  test("addOne - 10 + 1 = 11") {
    assert(addOne(10) === 11)
  }


}
