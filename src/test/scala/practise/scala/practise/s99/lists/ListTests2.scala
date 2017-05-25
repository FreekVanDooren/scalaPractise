package practise.s99.lists

import org.scalatest.FunSuite

import scala.annotation.tailrec
import scala.util.Random


/**
  * Created by freekvandooren on 12/10/16.
  */
class ListTests2 extends FunSuite {

  test("P15 (**) Duplicate the elements of a list a given number of times.") {
    def duplicateN(n: Int, list: List[Symbol]) = {
      list flatMap {
        List.fill(n)(_)
      }
    }
    assert(duplicateN(3, List('a, 'b, 'c, 'c, 'd)) == List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))
  }

  test("P16 (**) Drop every Nth element from a list.") {
    def drop(n: Int, list: List[Symbol]) = {
      list.sliding(n, n) flatMap { x => if (x.length == n) x.init else x } toList
    }
    assert(drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
  }

  test("P17 (*) Split a list into two parts.") {
    def splitBuiltIn(n: Int, list: List[Symbol]) = {
      list.splitAt(n)
    }
    def splitFunctional(n: Int, list: List[Symbol]) = {
      (list take n, list drop n)
    }
    assert(splitBuiltIn(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    assert(splitFunctional(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }

  test("P18 (**) Extract a slice from a list.") {
    def sliceFunctional(start: Int, end: Int, list: List[Symbol]) = {
      list.take(end).drop(start)
    }
    def sliceBuiltIn(start: Int, end: Int, list: List[Symbol]) = {
      list.slice(start, end)
    }
    assert(sliceFunctional(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == List('d, 'e, 'f, 'g))
    assert(sliceBuiltIn(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == List('d, 'e, 'f, 'g))
  }

  test("P19 (**) Rotate a list N places to the left.") {
    @tailrec
    def rotate[A](n: Int, list: List[A]): List[A] = {
      (n, list) match {
        case (0, _) => list
        case (i, _) if (i < 0) => rotate(i + 1, list.last :: list.init)
        case (i, _) if (i > 0) => rotate(i - 1, list.tail :+ list.head)
      }
    }
    assert(rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c))
    assert(rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i))
  }

  def removeAtAlternate[A](n: Int, list: List[A]): (List[A], A) = list.splitAt(n) match {
    case (pre, e :: pos) => (pre ::: pos, e)
    case _ => throw new HorribleException
  }

  test("P20 (*) Remove the Kth element from a list.") {
    def removeAt[A](n: Int, list: List[A]): (List[A], A) = {
      (list.zipWithIndex filter {
        _._2 != n
      } map {
        _._1
      }, list(n))
    }
    assert(removeAt(1, List('a, 'b, 'c, 'd)) == (List('a, 'c, 'd), 'b))
    assert(removeAtAlternate(1, List('a, 'b, 'c, 'd)) == (List('a, 'c, 'd), 'b))
  }


  test("P21 (*) Insert an element at a given position into a list.") {
    def insertAt(symbol: Symbol, pos: Int, symbols: List[Symbol]) = {
      symbols.take(pos) ::: (symbol :: symbols.drop(pos))
    }
    assert(insertAt('new, 1, List('a, 'b, 'c, 'd)) == List('a, 'new, 'b, 'c, 'd))
  }


  def rangeBuiltIn(start: Int, end: Int): List[Int] = List.range(start, end + 1)

  test("P22 (*) Create a list containing all integers within a given range.") {
    def rangeRecursive(start: Int, end: Int): List[Int] = {
      if (start > end) Nil
      else start :: rangeRecursive(start + 1, end)
    }
    assert(rangeBuiltIn(4, 9) == List(4, 5, 6, 7, 8, 9))
    assert(rangeRecursive(4, 9) == List(4, 5, 6, 7, 8, 9))
  }

  def randomSelect[A](i: Int, list: List[A]): List[A] = {
    if (i == 0) Nil
    else {
      val (remainder, removed): (List[A], A) = removeAtAlternate(Random.nextInt(list.size), list)
      removed :: randomSelect(i - 1, remainder)
    }
  }

  test("P23 (**) Extract a given number of randomly selected elements from a list.") {
    val input: List[Symbol] = List('a, 'b, 'c, 'd, 'f, 'g, 'h)
    val output: List[Symbol] = randomSelect(3, input)
    assert(output.distinct.size == 3)
    input assertContainsElementsOf output
  }

  implicit class ElementAssertion[A](list: List[A]) {
    def assertContainsElementsOf(otherList: List[A]) = {
      otherList foreach { x => assert(list.contains(x)) }
    }
  }

  test("P24 (*) Lotto: Draw N different random numbers from the set 1..M.") {
    def lotto(draws: Int, max: Int) = randomSelect(draws, rangeBuiltIn(1, max))
    val output: List[Int] = lotto(6, 49)
    assert(output.distinct.size == 6)
    assert(output.max <= 49)
    assert(output.min >= 1)
  }


  test("P25 (*) Generate a random permutation of the elements of a list.") {
    def randomPermute(symbols: List[Symbol]): List[Symbol] = randomSelect(symbols size, symbols)
    val input: List[Symbol] = List('a, 'b, 'c, 'd, 'e, 'f)
    val output: List[Symbol] = randomPermute(input)
    assert(output != input)
    assert(output.size == input.size)
    input assertContainsElementsOf output
  }

  implicit class SeqMultiply(end: Int) {
    def **(start: Int): Int = {
      if (start == end)
        return 1
      (start to end).foldLeft(1) { _ * _ }
    }
  }
  implicit class Factorial(in: Int) {
    def !(): Int = in ** 1
  }

  def combinationsSize(totalSize: Int, groupSize: Int): Int = totalSize ** (totalSize - groupSize + 1) / (groupSize!)

  def combinations[A](listSize: Int, list: List[A]): List[List[A]] = list combinations(listSize) toList

  test("P26 (**) Generate the combinations of K distinct objects chosen from the N elements of a list.") {

    val input: List[Symbol] = List('a, 'b, 'c, 'd, 'e, 'f)
    val listSize: Int = 3

    val output: List[List[Symbol]] = combinations(listSize, input)

    assert(output.size == combinationsSize(input size, listSize))
    output foreach (x => {
        assert(x.size == listSize)
        input assertContainsElementsOf x
      }
    )
  }


  test("P27 (**) Group the elements of a set into disjoint subsets.") {
    def multiNom(coeffs: List[Int]): Int = (coeffs.sum!) / coeffs.map(_!).reduce(_*_)
    implicit class RemoveFromList[A](list: List[A]) {
      def --(e: List[A]): List[A] ={
        list filterNot ( e contains _ )
      }
    }
    def group3[A](ls: List[A]): List[List[List[A]]] =
      for {
        a <- combinations(2, ls)
        noA = ls -- a
        b <- combinations(3, noA)
      } yield List(a, b, noA -- b)

    def group[A](ns: List[Int], ls: List[A]): List[List[List[A]]] = {
      if (ns.sum != ls.size)
        throw new HorribleException
      ns match {
        case Nil     => List(Nil)
        case n :: ns => combinations(n, ls) flatMap { c =>
          group(ns, ls -- c) map {c :: _}
        }
      }
    }
    val input: List[String] = List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")

    val grouped3: List[List[List[String]]] = group3(input)
    assert((grouped3 map ( _ flatten) distinct).size == multiNom(List(2,3,4)))
    grouped3 foreach( x => {
      assert(x.size == 3)
      assert(x(0).size == 2)
      assert(x(1).size == 3)
      assert(x(2).size == 4)
    })

    val groupSizes: List[Int] = List(2, 2, 5)
    val zippedGroupSizes: List[(Int, Int)] = groupSizes zipWithIndex
    val grouped: List[List[List[String]]] = group(groupSizes, input)
    assert((grouped map ( _ flatten) distinct).size == multiNom(groupSizes))
    grouped foreach( x => {
      assert(x.size == groupSizes.size)
      zippedGroupSizes.foreach(y => assert(y._1 == x(y._2).size))
    })

    intercept[HorribleException](
      group(List(2,2,4), input)
    )

  }

  test("P28 (**) Sorting a list of lists according to length of sublists.") {
    def lsortA[A](sortable: List[List[A]]): List[List[A]] = {
      sortable sortBy {_.length}
    }
    assert(
      lsortA(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
        ==
      List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l)))


    def lsortFreq[A](sortable: List[List[A]]): List[List[A]] = {
      def lengthFreq[A](element: List[A]): Int = {
        sortable.foldLeft(0)( (acc,el) =>
          if (el.length == element.length) acc + 1 else acc
        )
      }
      sortable sortWith {lengthFreq(_) < lengthFreq(_)}
    }

    assert (
      lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
        ==
      List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n))
    )
  }
}
