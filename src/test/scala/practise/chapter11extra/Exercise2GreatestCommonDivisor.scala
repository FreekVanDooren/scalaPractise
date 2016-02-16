package practise.chapter11extra


class Exercise2GreatestCommonDivisor extends org.scalatest.FunSuite {
  object Exercise {
    def greatestCommonDivisor(i1: Int, i2: Int): Int = ???
  }
  import Exercise._

  test("greatestCommonDivisor") {
    assert(greatestCommonDivisor(1, 10) === 1)
    assert(greatestCommonDivisor(15, 10) === 5)
    assert(greatestCommonDivisor(15, 21) === 3)
    assert(greatestCommonDivisor(15, 30) === 15)
  }

}