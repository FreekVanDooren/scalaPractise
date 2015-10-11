package practise.chapter5String

//Read http://docs.scala-lang.org/overviews/core/string-interpolation.html
class Exercise1StringInterpolation extends org.scalatest.FunSuite {
  object Exercise {
  }
  //startAnswer
  object Answer {
    def hello(name: String): String = s"Hello $name"
    def plus(i1: Int, i2: Int): String = s"$i1 + $i2 = ${i1 + i2}"
  }
  import Answer._
  //endAnswer

  test("Hello World") {
    assert(hello("World") === "Hello World")
  }

  test("plus") {
    assert(plus(1, 2) === "1 + 2 = 3")
    assert(plus(11, 12) === "11 + 12 = 23")
  }

}
