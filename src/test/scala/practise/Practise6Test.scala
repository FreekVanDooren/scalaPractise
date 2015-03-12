package practise

import org.scalatest.FunSuite
import practise.Practise6._

class Practise6Test extends FunSuite {

  test("allWordsIn") {
    assert(allWordsIn(List("bla", "bla")) === List("bla", "bla"))
    val story = List("Hard by a great forest dwelt a poor wood-cutter with his wife and his two children",
    "The boy was called Hansel and the girl Gretel", "He had little to bite and to break")
    val expectedWords = List("Hard", "by", "a", "great", "forest", "dwelt", "a", "poor", "wood-cutter", "with", "his", "wife", "and", "his", "two", "children", "The", "boy", "was", "called", "Hansel", "and", "the", "girl", "Gretel", "He", "had", "little", "to", "bite", "and", "to", "break")
    assert(allWordsIn(story) === expectedWords)
  }

  test("repeatWord") {
    assert(repeatWord(0, "bla") === Nil)
    assert(repeatWord(1, "hello") === List("hello"))
    assert(repeatWord(3, "bla") === List("bla", "bla", "bla"))
  }

  test("repeatWords") {
    assert(repeatWords(List((0, "zero"), (1, "one"), (2, "two"), (3, "three"))) ===
      List("one", "two", "two", "three", "three", "three"))
  }

}
