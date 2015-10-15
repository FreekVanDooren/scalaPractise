package practise.chapter7recursion

import org.scalatest.FunSuite

//Here we make an algorithm to compress strings.
//This exercise is harder than the previous exercises. Think well about the steps you'll need to do and what intermediate state you'll need to hold.
//Make helper functions
class Exercise2Compress extends FunSuite {
  object Exercise {
    //Compress a string by counting repeated characters. Best look at the unit tests for examples.
    //hint: recursion
    //string.toList makes a list of characters
    //list.mkString makes a String from a List
    //best make a helper method to do the recursion in
    def compress(s: String): String = ???

    //The reverse of compress
    def decompress(s: String): String = ???
  }
  //startAnswer
  object Answer {
    def compress(s: String): String = s.toList match {
      case Nil => ""
      case first :: rest => compress1(rest, first, 1).mkString
    }
    def compress1(list: List[Char], letter: Char, amount: Int): List[Char] = list match {
      case Nil => letterOutput(letter, amount)
      case first :: rest if first == letter => compress1(rest, letter, amount + 1)
      case first :: rest if first != letter => letterOutput(letter, amount) ::: compress1(rest, first, 1)
    }
    def letterOutput(letter: Char, amount: Int): List[Char] = {
      if (amount == 1) List(letter)
      else letter :: amount.toString.toList
    }

    def decompress(s: String): String = decompress1(s.toList).mkString
    def decompress1(list: List[Char]): List[Char] = list match {
      case Nil => Nil
      case first :: rest =>
        val digits: String = rest.takeWhile(isDigit).mkString
        val amount: Int = stringToAmount(digits)
        val restWithoutDigits: List[Char] = rest.dropWhile(isDigit)
        List.fill(amount)(first) ::: decompress1(restWithoutDigits)
    }
    def isDigit(c: Char): Boolean = {
      c == '0' || (c >= '1' && c <= '9')
    }
    def stringToAmount(s: String) = {
      if (s.isEmpty) 1
      else Integer.parseInt(s)
    }
  }
  import Answer._
  //endAnswer

  test("compress - no compression") {
    assert(compress("") === "")
    assert(compress("a") === "a")
    assert(compress("bla") === "bla")
    assert(compress("aba") === "aba")
  }

  test("compress - compression") {
    assert(compress("aa") === "a2")
    assert(compress("aaaaaaaaaaa") === "a11")
    assert(compress("abba") === "ab2a")
    assert(compress("aabbbcccaaaad") === "a2b3c3a4d")
  }

  test("decompress - no compression") {
    assert(decompress("") === "")
    assert(decompress("a") === "a")
    assert(decompress("bla") === "bla")
    assert(decompress("aba") === "aba")
  }

  test("decompress - compression") {
    assert(decompress("a2") === "aa")
    assert(decompress("a10") === "aaaaaaaaaa")
    assert(decompress("a11") === "aaaaaaaaaaa")
    assert(decompress("ab2a") === "abba")
    assert(decompress("a2b3c3a4d") === "aabbbcccaaaad")
  }


}
