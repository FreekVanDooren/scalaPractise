package practise.chapter6flatmap

import org.scalatest.FunSuite

import scala.util.{Success, Try}

//You can easily chain multiple tries with flatmap
class Exercise5Try extends FunSuite {
  class Step1Output
  class Step1Error
  def step1: Try[Step1Output] = Success(new Step1Output)

  class Step2Output
  def step2(x: Step1Output): Try[Step2Output] = Success(new Step2Output())

  object Exercise {
    def allSteps: Try[Step2Output] = ???
  }
  import Exercise._

  test("doAllSteps") {
    assert(allSteps.isSuccess)
  }
//


}