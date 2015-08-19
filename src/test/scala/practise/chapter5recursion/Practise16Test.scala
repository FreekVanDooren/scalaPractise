package practise.chapter5recursion

import org.scalatest.FunSuite

object Practise16 {
  //hint: recursion
  //best make a helper method to do the recursion in
  def decompress(s: String): String = ???

}

class Practise16Test extends FunSuite {
  import Practise16._

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
