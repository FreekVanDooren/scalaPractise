package practise.chapter11extra

//https://en.wikipedia.org/wiki/Multi-tap
//use 0 in between multiple letters under the same digit
class Exercise3Telephone extends org.scalatest.FunSuite {
  object Exercise {
    def textToKeypresses(text: String): List[Int] = ???
    def keypressesToText(keys: List[Int]): String = ???
   }
  import Exercise._

  test("textToKeypresses") {
    assert(textToKeypresses("a") === List(2))
    assert(textToKeypresses("tammo") === List(8, 2, 6, 0, 6, 0, 6, 6, 6))
  }

  test("keypressesToText") {
    assert(keypressesToText(List(2)) === "a")
    assert(keypressesToText(List(2, 2)) === "b")
    assert(keypressesToText(List(2, 2, 2)) === "c")
    assert(keypressesToText(List(2, 2, 2, 2)) === "a")
    assert(keypressesToText(List(2, 3)) === "ad")
    assert(keypressesToText(List(2, 0, 2)) === "aa")
    assert(keypressesToText(List(8, 2, 6, 0, 6, 0, 6, 6, 6)) === "tammo")
  }

}