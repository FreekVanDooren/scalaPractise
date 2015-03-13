package practise

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Practise8 {
  //hint: map and flatMap work on futures

  def addToFuture(f: Future[Int], add: Int): Future[Int] = ???

  def addFutures(f1: Future[Int], f2: Future[Int]): Future[Int] = ???

}
