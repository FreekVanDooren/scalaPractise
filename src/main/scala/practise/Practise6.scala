package practise

object Practise6 {
  //hint: flatmap

  //make one list with all words in the sentences
  def allWordsIn(sentences: List[String]): List[String] = sentences.flatMap { _.split(" ") }

  //hint: List.fill
  def repeatWord(times: Int, word: String): List[String] = List.fill(times)(word)
  def repeatWords(input: List[(Int, String)]): List[String] = input.flatMap { case (times, word) => repeatWord(times, word) }


}
