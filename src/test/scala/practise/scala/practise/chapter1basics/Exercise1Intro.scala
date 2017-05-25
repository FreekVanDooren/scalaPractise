package practise.chapter1basics

import org.scalatest.FunSuite

//To get comfortable with how this works.
//Run the unit tests. It will fail because the ???s here are not implemented.
//It's up to you to implement them
class Exercise1Intro extends FunSuite {
  //All stuff for you to do will be within an Exercise object.
  //This is done to have the tests runnable when there are still missing implementations (the ???s).
  //This also has the benefit to make it clear where you should make changes. Usually that will be filling in the ???s.
  object Exercise {
    //Make this method return true
    def shouldReturnTrue: Boolean = true
  }
  //We could use Exercise.shouldReturnTrue.
  //This import makes it easier so we can just use shouldReturnTrue.
  import Exercise._

  test("shouldReturnTrue - should return true") {
    assert(shouldReturnTrue === true)
  }
}