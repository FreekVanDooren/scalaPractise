package practise

import org.scalatest.FunSuite
import practise.Practise15._

class Practise15Test extends FunSuite {
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
