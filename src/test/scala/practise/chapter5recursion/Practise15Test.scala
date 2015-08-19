package practise.chapter5recursion

import org.scalatest.FunSuite

object Practise15 {
  //hint: recursion
  //string.toList makes a list of characters
  //list.mkString makes a String from a List
  //best make a helper method to do the recursion in
  def compress(s: String): String = ???

}

class Practise15Test extends FunSuite {
  import Practise15._

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

}
