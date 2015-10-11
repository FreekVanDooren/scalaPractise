package practise.chapter7stream

//Read http://www.scala-lang.org/api/current/index.html#scala.collection.immutable.Stream
class Exercise1InfiniteStream extends org.scalatest.FunSuite {
  object Exercise {
    //hint: create a helper method
    val allPositiveNumbers: Stream[Int] = ???

    //can you think of 2 different ways to do this?
    val evenNumbers1: Stream[Int] = ???
    val evenNumbers2: Stream[Int] = ???
  }
  //startAnswer
  object Answer {
    val allPositiveNumbers: Stream[Int] = numbersFrom(1)
    def numbersFrom(a: Int): Stream[Int] = a #:: numbersFrom(a + 1)

    val evenNumbers1: Stream[Int] = allPositiveNumbers.map { _ * 2 }
    val evenNumbers2: Stream[Int] = allPositiveNumbers.filter { _ % 2 == 0 }
  }
  import Answer._
  //endAnswer

  test("allPositiveNumbers - first 5") {
    assert(allPositiveNumbers.take(5).toList === List(1, 2, 3, 4, 5))
  }

  test("allPositiveNumbers") {
    assert(allPositiveNumbers(0) === 1)
    assert(allPositiveNumbers(1) === 2)
    assert(allPositiveNumbers(100) === 101)
  }

  test("evenNumbers1") {
    assert(evenNumbers1.take(5).toList === List(2, 4, 6, 8, 10))
    assert(evenNumbers1(100) === 202)
  }

  test("evenNumbers2") {
    assert(evenNumbers2.take(5).toList === List(2, 4, 6, 8, 10))
    assert(evenNumbers2(100) === 202)
  }

}
