package practise.chapter6flatmap

import org.scalatest.FunSuite

//hint: map and flatMap work on options
class Exercise4Options extends FunSuite {
  object Exercise {
    //add a number, if the option is something
    def addToOption(o: Option[Int], add: Int): Option[Int] = ???

    //use 0 if o is None
    def addToOptionWithDefault0(o: Option[Int], add: Int): Int = ???

    def addOptions(o1: Option[Int], o2: Option[Int]): Option[Int] = ???

    //use 0 for any option that is None
    def addOptionsWithDefault0(o1: Option[Int], o2: Option[Int]): Int = ???
  }
  import Exercise._

  test("addToOption - None") {
    assert(addToOption(None, 3) === None)
  }

  test("addToOption - Some") {
    assert(addToOption(Some(2), 3) === Some(5))
  }

  test("addToOptionWithDefault0 - None") {
    assert(addToOptionWithDefault0(None, 3) === 3)
  }

  test("addToOptionWithDefault0 - Some") {
    assert(addToOptionWithDefault0(Some(1), 3) === 4)
  }

  test("addOptions") {
    assert(addOptions(None, Some(4)) === None)
    assert(addOptions(Some(2), None) === None)
    assert(addOptions(None, None) === None)
    assert(addOptions(Some(2), Some(4)) === Some(6))
  }

  test("addOptionsWithDefault0") {
    assert(addOptionsWithDefault0(None, Some(4)) === 4)
    assert(addOptionsWithDefault0(Some(2), None) === 2)
    assert(addOptionsWithDefault0(None, None) === 0)
    assert(addOptionsWithDefault0(Some(2), Some(4)) === 6)
  }

}