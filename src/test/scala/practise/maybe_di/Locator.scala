package practise.maybe_di

import org.scalatest.FunSuite

//http://jonasboner.com/2008/10/06/real-world-scala-dependency-injection-di/
class Locator extends FunSuite {
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

    class Client(env: { val generator: Generator }) {
      val generator = env.generator

      def count: Int = generator.generateNumber
    }
  }
  import Answer._
  //endAnswer

  test("countTwice") {
    object Registry {
      val generator = new Generator
      val client = new Client(this)
    }

    assert(Registry.client.count === 1)
    assert(Registry.client.count === 2)
  }

  test("multiple clients") {
    object Registry {
      val generator = new Generator
    }
    val client1 = new Client(Registry)
    val client2 = new Client(Registry)

    assert(client1.count === 1)
    assert(client2.count === 2)
    assert(client1.count === 3)
  }

}
