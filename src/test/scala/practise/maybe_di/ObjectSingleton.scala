package practise.maybe_di

import org.scalatest.FunSuite

//http://jonasboner.com/2008/10/06/real-world-scala-dependency-injection-di/
class ObjectSingleton extends FunSuite {
  object Exercise {
  }
  //startAnswer
  object Answer {
    object Generator {
      private var current = 0
      def generateNumber: Int = {
        current = current + 1
        current
      }
    }

    class Client() {
      def count: Int = Generator.generateNumber
    }
  }
  import Answer._
  //endAnswer

  test("countTwice") {
    val client = new Client()

    assert(client.count === 1)
    assert(client.count === 2)
  }

  ignore("multiple clients") { //It will still have state from the previous test
    val client1 = new Client()
    val client2 = new Client()

    assert(client1.count === 1)
    assert(client2.count === 2)
    assert(client1.count === 3)
  }

}
