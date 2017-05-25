package practise.chapter11extra


class Exercise2GreatestCommonDivisor extends org.scalatest.FunSuite {
  object Exercise {
    def divisors(i: Int): Traversable[Int] = {
      (for {
        s1 <- 1 to i
        s2 <- 1 to i
        if (s1 * s2 == i)
      } yield Traversable(s1, s2)).flatten
    }
    def greatestCommonDivisor(i1: Int, i2: Int): Int = {
      (for {
        k1 <- divisors(i1)
        k2 <- divisors(i2)
        if (k1 == k2)
      } yield k1).max
    }
  }
  import Exercise._

  test("greatestCommonDivisor") {
    assert(greatestCommonDivisor(1, 10) === 1)
    assert(greatestCommonDivisor(15, 10) === 5)
    assert(greatestCommonDivisor(15, 21) === 3)
    assert(greatestCommonDivisor(15, 30) === 15)
  }

}