package practise.chapter9stream

//Read http://www.scala-lang.org/api/current/index.html#scala.collection.immutable.Stream
class Exercise1InfiniteStream extends org.scalatest.FunSuite {
  object Exercise {

    //hint: create a helper method
    val allPositiveNumbers: Stream[Int] = 1 #:: allPositiveNumbers.map(x => x + 1)

    //can you think of 2 different ways to do this?
    val evenNumbers1: Stream[Int] = allPositiveNumbers filter {x => x % 2 == 0 }
    val evenNumbers2: Stream[Int] = Stream.from(2, 2)
  }
  import Exercise._

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