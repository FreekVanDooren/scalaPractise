package practise.chapter9stream

class Exercise2Primes extends org.scalatest.FunSuite {

  object Exercise {
    //Use your favorite method to calculate primes
    //hint: 0 and 1 are not primes
    val primes: Stream[Int] = 2 #:: Stream.from(3,2).filter(n => primes.takeWhile(p => p * p <= n).forall(n % _ != 0))
  }

  import Exercise._

  test("primes - first 5") {
    assert(primes.take(5).toList === List(2, 3, 5, 7, 11))
  }

  test("primes - the 26th prime is 101") {
    assert(primes(25) === 101)
  }

}