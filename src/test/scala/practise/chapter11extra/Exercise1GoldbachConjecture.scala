package practise.chapter11extra

//Goldbach's conjecture.
//Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers.
// Example: 28 = 5 + 23.
// It is one of the most famous facts in number theory that has not been proved to be correct in the general case.
// It has been numerically confirmed up to very large numbers (much larger than we can go with our Prolog system).
// Write a predicate to find the two prime numbers that sum up to a given even integer.
class Exercise1GoldbachConjecture extends org.scalatest.FunSuite {
  object Exercise {
    def goldbach(i: Int): (Int, Int) = ???
  }
  import Exercise._

  test("goldbach") {
    assert(goldbach(4) === (2, 2))
    assert(goldbach(7) === (2, 5))
    assert(goldbach(28) === (5, 23))
  }

}