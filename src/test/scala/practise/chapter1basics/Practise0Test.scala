package practise.chapter1basics

import org.scalatest.FunSuite

//A practise to get comfortable with how this works
//Run the unit tests in Practise0Test. It will fail because the ???s here are not implemented.
//It's up to you to implement them
object Practise0 {

  //Make this method return true
  def shouldReturnTrue(): Boolean = ???

  //Add one to x
  def addOne(x: Int): Int = ???

}



class Practise0Test extends FunSuite {
  import Practise0._ //so we can reference the methods in the Practise0 object directly instead of having to call them like PractiseO.shouldReturnTrue()

  test("shouldReturnTrue - should return true") {
    assert(shouldReturnTrue() === true)
  }

  test("addOne - 1 + 1 = 2") {
    assert(addOne(1) === 2)
  }

  test("addOne - 10 + 1 = 11") {
    assert(addOne(10) === 11)
  }


}
