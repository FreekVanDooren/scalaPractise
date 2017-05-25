package practise.chapter2collections

import java.util

import org.scalatest.FunSuite

//Working with Option
//read: http://danielwestheide.com/blog/2012/12/19/the-neophytes-guide-to-scala-part-5-the-option-type.html
class Exercise5Option extends FunSuite {
  val javaMap: java.util.Map[Int, Int] = new util.HashMap[Int, Int]()
  javaMap.put(1, 1)
  javaMap.put(2, 2)

  object Exercise {
    //find the first even number in a list of numbers
    def firstEven(list: List[Int]): Option[Int] = list.find(_ % 2 == 0)

    //find the first even number in a list of numbers and half it
    def halfFirstEven(list: List[Int]): Option[Int] = firstEven(list).map(x => x/2)

    //Java libraries may return null.
    //Using null is not the Scala way. We want to catch "nullpointer errors" at compile time.
    //So call javaMap.get and transform the result into an Option
    def javaLibraryWrapper(i: Int): Option[Int] = Option(javaMap.get(i))
  }
  import Exercise._

  test("firstEven") {
    assert(firstEven(Nil) === None)
    assert(firstEven(List(4)) === Some(4))
    assert(firstEven(List(5, 6)) === Some(6))
    assert(firstEven(List(5, 6, 7, 8)) === Some(6))
  }

  test("halfFirstEven") {
    assert(halfFirstEven(Nil) === None)
    assert(halfFirstEven(List(4)) === Some(2))
    assert(halfFirstEven(List(5, 6)) === Some(3))
    assert(halfFirstEven(List(5, 6, 7, 8)) === Some(3))
  }

  test("javaLibraryWrapper") {
    assert(javaLibraryWrapper(1) === Some(1))
    assert(javaLibraryWrapper(2) === Some(2))
    assert(javaLibraryWrapper(11) === None)
  }

}