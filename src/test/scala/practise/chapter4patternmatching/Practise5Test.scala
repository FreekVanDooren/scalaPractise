package practise.chapter4patternmatching

import org.scalatest.FunSuite

object Practise5 {
  case class Singer(name: String)
  case class Programmer(firstName: String)

  //hint: use match/case
  def nameOf(o: Object): String = ???
}

class Practise5Test extends FunSuite {
  import Practise5._

  test("match") {
    assert(nameOf(Singer("Dries Roelvink")) === "Dries Roelvink")
    assert(nameOf(Programmer("Tammo")) === "Tammo")
  }

}
