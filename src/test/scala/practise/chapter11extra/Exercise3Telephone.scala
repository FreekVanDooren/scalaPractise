package practise.chapter11extra

//https://en.wikipedia.org/wiki/Multi-tap
class Exercise3Telephone extends org.scalatest.FunSuite {
  object Exercise {
  }
  //startAnswer
  object Answer {
    def textToKeypresses(text: String): List[Int] = ???
    def keypressesToText(keys: List[Int]): String = ???
  }
  import Answer._
  //endAnswer

  test("textToKeypresses") {
    assert(textToKeypresses("a") === List(2))
  }

}
