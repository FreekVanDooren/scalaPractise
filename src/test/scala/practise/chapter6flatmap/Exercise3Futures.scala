package practise.chapter6flatmap

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
  import Exercise._

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