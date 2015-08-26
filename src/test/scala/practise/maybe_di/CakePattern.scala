package practise.maybe_di

import org.scalatest.FunSuite

//http://jonasboner.com/2008/10/06/real-world-scala-dependency-injection-di/
class CakePattern extends FunSuite {
  object Exercise {
  }
  //startAnswer
  object Answer {
    trait GeneratorTrait {
      val generator = new Generator
      class Generator {
        private var current = 0
        def generateNumber: Int = {
          current = current + 1
          current
        }
      }
    }

    trait ClientTrait { this: GeneratorTrait =>
      val client = new Client()
      class Client {
        def count: Int = generator.generateNumber
      }
    }
  }
  import Answer._
  //endAnswer

  test("countTwice") {
    object Registry extends ClientTrait with GeneratorTrait

    assert(Registry.client.count === 1)
    assert(Registry.client.count === 2)
  }

  //No multiple clients possible :(

}
