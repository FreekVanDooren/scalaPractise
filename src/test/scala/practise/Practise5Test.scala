package practise

import org.scalatest.FunSuite
import practise.Practise5._

class Practise5Test extends FunSuite {

  test("match") {
    assert(nameOf(Singer("Dries Roelvink")) === "Dries Roelvink")
    assert(nameOf(Programmer("Tammo")) === "Tammo")
  }

}
