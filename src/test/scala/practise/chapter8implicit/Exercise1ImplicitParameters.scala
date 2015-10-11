package practise.chapter8implicit

//Read http://docs.scala-lang.org/tutorials/FAQ/finding-implicits.html
class Exercise1ImplicitParameters extends org.scalatest.FunSuite {
  object Exercise {
    //create a method that takes an implicit String parameter
    def hello(implicit name: String): String = ???

    //call that method
    def helloWorld: String = ???
  }
  //startAnswer
  object Answer {
    def hello(implicit name: String): String = s"Hello $name"
    def helloWorld: String = {
      implicit val world = "World"
      hello
    }
  }
  import Answer._
  //endAnswer

  test("Hello Scala") {
    implicit val scala = "Scala"
    assert(hello === "Hello Scala")
  }

  test("Hello World") {
    assert(helloWorld === "Hello World")
  }

}
