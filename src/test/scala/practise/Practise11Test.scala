package practise

import org.scalatest.FunSuite
import practise.Practise11._

class Practise11Test extends FunSuite {
  val list123 = LinkedList("1", LinkedList("2", LinkedList("3", EmptyList)))

  test("apply - on EmptyList") {
    intercept[IndexOutOfBoundsException] {
      EmptyList(0)
    }
  }

  test("apply - 0") {
    assert(list123(0) === "1")
  }

  test("apply - 1") {
    assert(list123(1) === "2")
  }

  test("apply - 2") {
    assert(list123(2) === "3")
  }

  test("apply - 3") {
    intercept[IndexOutOfBoundsException] {
      EmptyList(3)
    }
  }



}
