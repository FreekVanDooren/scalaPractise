package practise.chapter3patternmatching

import org.scalatest.FunSuite

class Exercise4Anything extends FunSuite {
  case class Singer(name: String)
  abstract class CaseObject(val name: String)
  object SwimmingTrunks extends CaseObject("swimming trunks")
  object RhymingDictionary extends CaseObject("rhyming dictionary")

  object Exercise {
    def matchAnything(o: Any): String = {
      o match {
        case i: Int if i < 100 => i.toString
        case i: Int if i >= 100 => "too much"
        case st: CaseObject => st.name
        case sing: Singer => "a singer called %s".format(sing.name)
        case list: List[Any] => "a list with %d elements".format(list.size)
        case func: Function[Any, Any] => "a function"
        case _ => "something else"
      }
    }
  }
  import Exercise._

  test("numbers - Anything under 100 returns itself as a String") {
    (1 to 99).foreach { i =>
      assert(matchAnything(i) === i.toString)
    }
  }

  test("numbers - Anything above 100 returns too much") {
    (101 to 200).foreach { i =>
      assert(matchAnything(i) === "too much")
    }
  }

  test("objects") {
    assert(matchAnything(SwimmingTrunks) === "swimming trunks")
    assert(matchAnything(RhymingDictionary) === "rhyming dictionary")
  }

  test("toppers") {
    assert(matchAnything(Singer("René Froger")) === "a singer called René Froger")
    assert(matchAnything(Singer("Gerard Joling")) === "a singer called Gerard Joling")
  }

  test("List") {
    assert(matchAnything(List(1, 2, 3)) === "a list with 3 elements")
    assert(matchAnything(List(1, 2, 3, 4, 5, 6)) === "a list with 6 elements")
  }

  test("functions") {
    val f1: Function[Int, Int] = { i: Int => i + 1 }
    assert(matchAnything(f1) === "a function")
    assert(matchAnything({ i: Int => i.toString }) === "a function")
  }

  test("anything else") {
    val long: Long = 2L
    assert(matchAnything(long) === "something else")
  }

}