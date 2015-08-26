package practise.maybe_di

import org.scalatest.FunSuite

//http://jonasboner.com/2008/10/06/real-world-scala-dependency-injection-di/
class Implicit extends FunSuite {
  object Exercise {
  }
  //startAnswer
  object Answer {
    class Generator {
      private var current = 0
      def generateNumber: Int = {
        current = current + 1
        current
      }
    }

    class Client(implicit val generator: Generator) {
      def count: Int = generator.generateNumber
    }
  }
  import Answer._
  //endAnswer

  test("countTwice") {
    implicit val generator = new Generator
    val client = new Client()

    assert(client.count === 1)
    assert(client.count === 2)
  }

  test("multiple clients") {
    implicit val generator = new Generator
    val client1 = new Client()
    val client2 = new Client()

    assert(client1.count === 1)
    assert(client2.count === 2)
    assert(client1.count === 3)
  }

}
