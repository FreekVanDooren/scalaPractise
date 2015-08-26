package practise.chapter5flatmap

import org.scalatest.FunSuite
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

//hint: map and flatMap work on futures
class Exercise3Futures extends FunSuite {
  object Exercise {
    def addToFuture(f: Future[Int], add: Int): Future[Int] = ???

    def addFutures(f1: Future[Int], f2: Future[Int]): Future[Int] = ???
  }
  //startAnswer
  object Answer {
    def addToFuture(f: Future[Int], add: Int): Future[Int] = f.map(_ + add)

    def addFutures(f1: Future[Int], f2: Future[Int]): Future[Int] = f1.flatMap { i1 =>
      f2.map { i2 => i1 + i2 }
    }
  }
  import Answer._
  //endAnswer

  test("addToFuture") {
    val f: Future[Int] = Future { 1 + 1 }
    assert(Await.result(addToFuture(f, 3), 1 second) === 5)
  }

  test("addFutures") {
    val f1: Future[Int] = Future { 1 + 1 }
    val f2: Future[Int] = Future { 1 + 2 }
    assert(Await.result(addFutures(f1, f2), 1 second) === 5)
  }

}
