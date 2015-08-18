package practise

import org.scalatest.FunSuite
import practise.chapter5recursion.Practise16
import Practise16._

class Practise16Test extends FunSuite {
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
