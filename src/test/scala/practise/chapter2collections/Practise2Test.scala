package practise.chapter2collections

import org.scalatest.FunSuite

object Practise2 {
  def map(list: List[Int], method: (Int => Int)): List[Int] = ???
}

class Practise2Test extends FunSuite {
  import Practise2._

  test("map") {
    assert(map(List(1, 2, 3), { _ + 1}) === List(2, 3, 4))
    assert(map(List(2, 3, 4), { _ + 1}) === List(3, 4, 5))
    assert(map(List(1, 2, 3), { _ * 2}) === List(2, 4, 6))
    assert(map(List(1, 2, 3), { _ - 1}) === List(0, 1, 2))
  }

}
