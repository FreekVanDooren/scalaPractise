package practise.chapter3patternmatching

import org.scalatest.FunSuite

object Practise5 {
  case class Singer(name: String)
  case class Programmer(firstName: String)

  //hint: use match/case
  def nameOf(o: Object): String = ???
}

class Exercise3CaseClasses extends FunSuite {
  import Practise5._

  test("match") {
    assert(nameOf(Singer("Dries Roelvink")) === "Dries Roelvink")
    assert(nameOf(Programmer("Tammo")) === "Tammo")
  }

}
