package practise.chapter11extra

//Goldbach's conjecture.
//Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers.
// Example: 28 = 5 + 23.
// It is one of the most famous facts in number theory that has not been proved to be correct in the general case.
// It has been numerically confirmed up to very large numbers (much larger than we can go with our Prolog system).
// Write a predicate to find the two prime numbers that sum up to a given even integer.
class Exercise1GoldbachConjecture extends org.scalatest.FunSuite {
  object Exercise {
    val primes: Stream[Int] = 2 #:: Stream.from(3,2).filter(n => primes.takeWhile(p => p * p <= n).forall(n % _ != 0))
    def goldbach(i: Int): (Int, Int) = (for {p1 <- primes.takeWhile(_ < i)
                                             p2 <- primes.takeWhile(_ < i)
    if (p1 + p2 == i)} yield (p1, p2)).head
  }
  import Exercise._

  test("goldbach") {
    assert(goldbach(4) === (2, 2))
    assert(goldbach(7) === (2, 5))
    assert(goldbach(28) === (5, 23))
  }

}