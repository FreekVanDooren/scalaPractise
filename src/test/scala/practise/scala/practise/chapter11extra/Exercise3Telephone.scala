package practise.chapter11extra

import scala.collection.mutable.ListBuffer

//https://en.wikipedia.org/wiki/Multi-tap
//use 0 in between multiple letters under the same digit
class Exercise3Telephone extends org.scalatest.FunSuite {
  object Exercise {
    val keyCharacters: Map[Int, List[Char]] =
      Map(
        2 -> List('a','b','c'),
        3 -> List('d','e','f'),
        4 -> List('g','h','i'),
        5 -> List('j','k','l'),
        6 -> List('m','n','o'),
        7 -> List('p','q','r','s'),
        8 -> List('t','u','v'),
        9 -> List('w','x','y','z'),
        0 -> List()
      )

    def textToKeypresses(text: String): List[Int] = {

      def getKeyPresses(char : Char): ListBuffer[Int] = {
        val keyChars: (Int, List[Char]) = keyCharacters.find(_._2.contains(char)).get
        val nrOfPresses: Int = keyChars._2.indexOf(char) + 1
        ListBuffer.fill(nrOfPresses)(keyChars._1)
      }
      def flatten(keyPresses: List[ListBuffer[Int]]): List[Int] = {
        keyPresses.sliding(2).toList.map { x =>
          if (x.size > 1 && x(0).head === x(1).head) x(0) += 0
        }
        keyPresses flatten
      }
      flatten(text.toList.map(getKeyPresses(_)))
    }

    class IntCounter(int: Int){
      var counter = 0
      val characters: List[Char] = keyCharacters(int)

      def increment() = counter match {
        case x if x >= characters.size - 1 => counter = 0
        case _ => counter += 1
      }

      def isInt(int: Int): Boolean = this.int == int
      override def toString: String = {
        characters(counter) toString
      }
    }

    def keypressesToText(keys: List[Int], intCounters: List[IntCounter]): List[IntCounter] = {
      def updateCounters(key: Int, intCounters: List[IntCounter]): List[IntCounter] = {
        val lastCounter: IntCounter = intCounters.last
        if (lastCounter.isInt(key)) {
          lastCounter.increment()
          return intCounters
        }
        return intCounters :+ new IntCounter(key)
      }
      keys match {
        case Nil => intCounters
        case 0 :: tail => keypressesToText(tail.tail, intCounters :+ new IntCounter(tail.head))
        case lastInt :: Nil => updateCounters(lastInt, intCounters)
        case head :: tail => keypressesToText(tail, updateCounters(head, intCounters))
      }
    }

    def keypressesToText(keys: List[Int]): String = {
      keypressesToText(keys.tail, new IntCounter(keys.head) :: Nil) mkString
    }
   }
  import Exercise._

  test("textToKeypresses") {
    assert(textToKeypresses("a") === List(2))
    assert(textToKeypresses("tammo") === List(8, 2, 6, 0, 6, 0, 6, 6, 6))
  }

  test("keypressesToText") {
    assert(keypressesToText(List(2)) === "a")
    assert(keypressesToText(List(2, 2)) === "b")
    assert(keypressesToText(List(2, 2, 2)) === "c")
    assert(keypressesToText(List(2, 2, 2, 2)) === "a")
    assert(keypressesToText(List(2, 3)) === "ad")
    assert(keypressesToText(List(2, 0, 2)) === "aa")
    assert(keypressesToText(List(8, 2, 6, 0, 6, 0, 6, 6, 6)) === "tammo")
  }

}