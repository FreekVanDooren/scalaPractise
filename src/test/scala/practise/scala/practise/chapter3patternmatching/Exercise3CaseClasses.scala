package practise.chapter3patternmatching

import org.scalatest.FunSuite

class Exercise3CaseClasses extends FunSuite {
  case class Singer(name: String)
  case class Programmer(firstName: String)

  object Exercise {
    def toppers: List[Singer] = Singer("René Froger") :: Singer("Gordon") :: Singer("Gerard Joling") :: Nil

    //hint: use match/case
    def nameOf(o: Object): String = {
      o match {
        case singer: Singer => singer.name
        case programmer: Programmer => programmer.firstName
      }
    }
  }
  import Exercise._

  test("toppers") {
    assert(toppers.map(_.name) === List("René Froger", "Gordon", "Gerard Joling"))
  }

  test("match") {
    assert(nameOf(Singer("Dries Roelvink")) === "Dries Roelvink")
    assert(nameOf(Programmer("Tammo")) === "Tammo")
  }

}