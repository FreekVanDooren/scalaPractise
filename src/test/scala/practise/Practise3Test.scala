package practise

import org.scalatest.FunSuite
import practise.Practise2._

class Practise3Test extends FunSuite {

  test("map") {
    assert(map(List(1, 2, 3), { _ + 1}) === List(2, 3, 4))
    assert(map(List(2, 3, 4), { _ + 1}) === List(3, 4, 5))
    assert(map(List(1, 2, 3), { _ * 2}) === List(2, 4, 6))
    assert(map(List(1, 2, 3), { _ - 1}) === List(0, 1, 2))
  }

}
