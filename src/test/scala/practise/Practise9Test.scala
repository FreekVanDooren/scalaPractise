package practise

import org.scalatest.FunSuite
import Practise9._

class Practise9Test extends FunSuite {

  test("listContains - emptyList") {
    assert(!listContains(EmptyList, "1"))
  }

  test("listContains - (1, 2)") {
    val list = LinkedList("1", LinkedList("2", EmptyList))
    assert(listContains(list, "1"))
    assert(listContains(list, "2"))
    assert(!listContains(list, "3"))
  }

}
