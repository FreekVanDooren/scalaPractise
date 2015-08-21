package practise.chapter5flatmap

import org.scalatest.FunSuite

//read: http://twitter.github.io/effectivescala/#Functional programming-`flatMap`
class Exercise1RepeatWords extends FunSuite {
  object Exercise {
    //make one list with all words in the sentences
    //hint: String.split
    def allWordsIn(sentences: List[String]): List[String] = ???

    //hint: List.fill
    def repeatWord(times: Int, word: String): List[String] = ???

    //repeat all the words in the input list the specified number of times
    def repeatWords(input: List[(Int, String)]): List[String] = ???
  }
  //startAnswer
  object Answer {
  }
  import Answer._
  //endAnswer

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
