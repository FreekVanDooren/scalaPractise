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