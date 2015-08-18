package practise

import org.scalatest.FunSuite
import practise.chapter3flatmap.Practise8
import Practise8._

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

class Practise8Test extends FunSuite {

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
