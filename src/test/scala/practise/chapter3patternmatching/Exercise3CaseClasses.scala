package practise.chapter3patternmatching

import org.scalatest.FunSuite

class Exercise3CaseClasses extends FunSuite {
  case class Singer(name: String)
  case class Programmer(firstName: String)

  object Exercise {
    def toppers: List[Singer] = ???

    //hint: use match/case
    def nameOf(o: Object): String = ???
  }
  //startAnswer
  object Answer {
    def toppers: List[Singer] = List(Singer("René Froger"), Singer("Gordon"), Singer("Gerard Joling"))

    def nameOf(o: Object): String = o match {
      case Singer(name) => name
      case Programmer(name) => name
    }
  }
  import Answer._
  //endAnswer

  test("toppers") {
    assert(toppers.map(_.name) === List("René Froger", "Gordon", "Gerard Joling"))
  }

  test("match") {
    assert(nameOf(Singer("Dries Roelvink")) === "Dries Roelvink")
    assert(nameOf(Programmer("Tammo")) === "Tammo")
  }

}
