package practise.chapter7recursion

import org.scalatest.FunSuite

import scala.util.Try
import scala.util.matching.Regex
import scala.util.matching.Regex.Match

//Here we make an algorithm to compress strings.
//This exercise is harder than the previous exercises. Think well about the steps you'll need to do and what intermediate state you'll need to hold.
//Make helper functions
class Exercise2Compress extends FunSuite {
  object Exercise {

    class CharCounter(char: Char){

      var counter = 1

      def increment() = counter = counter + 1

      def isChar(char: Char): Boolean = {
        this.char === char
      }

      override def toString: String = {
        val s: String = char toString;
        if (counter > 1) s + counter
        else s
      }
    }

    //Compress a string by counting repeated characters. Best look at the unit tests for examples.
    //hint: recursion
    //string.toList makes a list of characters
    //list.mkString makes a String from a List
    //best make a helper method to do the recursion in
    def compress(s: String): String = {
      if (s isEmpty)
        return s
      val chars: List[Char] = s.toList
      compress(chars.tail, new CharCounter(chars.head) :: Nil) mkString
    }

    def compress(characters: List[Char], counters: List[CharCounter]): List[CharCounter] = {
      characters match {
        case Nil => counters
        case lastChar :: Nil => updateCharCounters(lastChar, counters)
        case head :: tail => compress(tail, updateCharCounters(head, counters))
      }
    }

    def updateCharCounters(currentChar: Char, counters: List[CharCounter]): List[CharCounter] = {
      var lastCounter: CharCounter = counters.last
      if (lastCounter.isChar(currentChar)) {
        lastCounter.increment()
        return counters
      }
      return counters :+ new CharCounter(currentChar)
    }

    //The reverse of compress
    def decompress(s: String): String = {
      if (s isEmpty)
        return s
      "([a-z])(\\d*)".r findAllMatchIn s flatMap {
        matched => {
          List.fill(parse(matched.group(2)))(matched.group(1))
        }
      } mkString
    }

    def parse(s: String): Int = Try(Integer.parseInt(s)) getOrElse 1
  }
  import Exercise._

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