package practise.chapter2collections

import org.scalatest.FunSuite

class Exercise2Map extends FunSuite {
  object Exercise {
    //Two arguments
    //1. a list of integers
    //2. a function from Int to Int. Notice the nice syntax.
    def map(list: List[Int], function: (Int => Int)): List[Int] = ???
  }
  import Exercise._

  test("map") {
    assert(map(List(1, 2, 3), { _ + 1}) === List(2, 3, 4))
    assert(map(List(2, 3, 4), { _ + 1}) === List(3, 4, 5))
    assert(map(List(1, 2, 3), { _ * 2}) === List(2, 4, 6))
    assert(map(List(1, 2, 3), { _ - 1}) === List(0, 1, 2))
  }

}
