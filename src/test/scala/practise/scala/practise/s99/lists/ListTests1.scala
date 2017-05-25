package practise.s99.lists

import org.scalatest.FunSuite

/**
  * http://aperiodic.net/phil/scala/s-99/
  */
class ListTests1 extends FunSuite{

  test("P01 (*) Find the last element of a list.") {
    def lastRec(list: List[Int]): Int = {
      // Recursive:
      list match {
        case h :: Nil => h
        case _ :: tail => lastRec(tail)
        case _ => throw new HorribleException
      }
    }
    def lastBuiltIn(list: List[Int]): Int = list last
    def lastFunctional(list: List[Int]): Int = list.fold(0)((x,y) => y)

    assert(lastRec(List(1, 1, 2, 3, 5, 8)) == 8)
    assert(lastBuiltIn(List(1, 1, 2, 3, 5, 8)) == 8)
    assert(lastFunctional(List(1, 1, 2, 3, 5, 8)) == 8)
  }

  test("P02 (*) Find the last but one element of a list.") {
    def penultimateRec(list: List[Int]): Int = {
      // Recursive :
      list match {
        case h :: _ :: Nil => h
        case _ :: tail => penultimateRec(tail)
        case _ => throw new HorribleException
      }
    }
    def penultimateBuiltIn(list: List[Int]): Int = (list init) last
    def penultimateFunctional(list: List[Int]): Int = list.takeRight(2).head

    assert(penultimateRec(List(1, 1, 2, 3, 5, 8)) == 5)
    assert(penultimateBuiltIn(List(1, 1, 2, 3, 5, 8)) == 5)
    assert(penultimateFunctional(List(1, 1, 2, 3, 5, 8)) == 5)
  }

  test("P03 (*) Find the Kth element of a list.") {
    def nth(n: Int, list: List[Int]): Int = {
      // Recursive:
      (n, list) match {
        case (0, ls :: _) => ls
        case (n, _ :: tail) => nth(n - 1, tail)
        case _ => throw new HorribleException
      }
      // Built in: list(n)
    }
    assert(nth(2, List(1, 1, 2, 3, 5, 8)) == 2)
  }

  test("P04 (*) Find the number of elements of a list.") {
    def lengthBuiltIn1(list: List[Int]) = list length
    def lengthBuiltIn2(list: List[Int]) = list size
    def lengthRec(list: List[Int]) = {
      // Recursive:
      def lengthRec(list: List[Int], curLength: Int): Int = {
        list match {
          case Nil => curLength
          case _ :: tail => lengthRec(tail, curLength + 1)
          case _ => throw new HorribleException
        }
      }
      lengthRec(list, 0)
    }
    def lengthFunctional(list: List[Int]) = list.fold(0)((x, y) => x + 1)

    assert(lengthBuiltIn1(List(1, 1, 2, 3, 5, 8)) == 6)
    assert(lengthBuiltIn2(List(1, 1, 2, 3, 5, 8)) == 6)
    assert(lengthRec(List(1, 1, 2, 3, 5, 8)) == 6)
    assert(lengthFunctional(List(1, 1, 2, 3, 5, 8)) == 6)
  }


  test("P05 (*) Reverse a list.") {
    def reverseBuiltIn(list: List[Int]) = list reverse
    def reverseRec(list: List[Int]) = {
      def reverseRec(list: List[Int], reversed: List[Int]): List[Int] = {
        list match {
          case Nil => reversed
          case h :: tail => reverseRec(tail, h :: reversed)
          case _ => throw new HorribleException
        }
      }
      reverseRec(list, List())
    }
    def reverseFunctional(list: List[Int]) = list.foldLeft(List[Int]()) { (r, h) => h :: r}
    assert(reverseBuiltIn(List(1, 1, 2, 3, 5, 8)) == List(8, 5, 3, 2, 1, 1))
    assert(reverseRec(List(1, 1, 2, 3, 5, 8)) == List(8, 5, 3, 2, 1, 1))
    assert(reverseFunctional(List(1, 1, 2, 3, 5, 8)) == List(8, 5, 3, 2, 1, 1))
  }

  test("P06 (*) Find out whether a list is a palindrome.") {
    def isPalindrome(list: List[Int]): Boolean = {
      list match {
        case h :: tail if ((tail isEmpty) || (tail size) == 1) => true
        case h :: tail if (h == tail.last) =>  isPalindrome(tail.init)
        case Nil => true
        case _ => false
      }
    }
    assert(isPalindrome(List(1, 2, 3, 2, 1)))
    assert(isPalindrome(List(1, 2, 2, 1)))
    assert(isPalindrome(List(1)))
    assert(isPalindrome(List()))
    assert(isPalindrome(List(1, 2, 3, 4, 1)) == false)
  }

  test("P07 (**) Flatten a nested list structure.") {
    def flatten(list: List[Any]): List[Any] = {
      list flatMap {
        case ls: List[_] => flatten(ls)
        case e => List(e)
      }
    }
    assert(flatten(List(List(1, 1), 2, List(3, List(5, 8)))) == List(1, 1, 2, 3, 5, 8))
  }


  test("P08 (**) Eliminate consecutive duplicates of list elements.") {
    def compress(list: List[Symbol]) = list.foldLeft(List[Symbol]())(
      (output,element) =>
        if (output.isEmpty || output.last != element) output :+ element else output
    )
    assert(compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) == List('a, 'b, 'c, 'a, 'd, 'e))
  }


  def packHomeMade(list: List[Symbol]): List[List[Symbol]] = {
    list match {
      case head :: tail =>
        List(head :: tail.takeWhile((p: Symbol) => p == head)) ::: packHomeMade(list.dropWhile((p: Symbol) => p == head))
      case Nil => Nil
    }
  }
  test("P09 (**) Pack consecutive duplicates of list elements into sublists.") {
    def packAnswer(list: List[Symbol]): List[List[Symbol]] = {
      if (list isEmpty) Nil
      else {
        val (packed, next) = list span { _ == list.head }
        packed :: packAnswer(next)
      }
    }
    assert(packHomeMade(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) == List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
    assert(packAnswer(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) == List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
  }

  def encodeHomeMade(list: List[Symbol]) = {
    packHomeMade(list).foldRight(List[(Int, Symbol)]())(
      (element, output) => (element size, element head) :: output
    )
  }
  test("P10 (*) Run-length encoding of a list.") {
    def encodeMap(list: List[Symbol]) = {
      packHomeMade(list) map {e => (e size, e head)}
    }
    assert(encodeHomeMade(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) == List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
    assert(encodeMap(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) == List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
  }

  test("P11 (*) Modified run-length encoding.") {
    def encodeModified(list: List[Symbol]) = {
      encodeHomeMade(list) map {e => e match {
        case (1, x) => x
        case tuple => tuple
      }}
    }
    assert(encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) == List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)))
  }

  test("P12 (**) Decode a run-length encoded list.") {
    def decode(tuples: List[(Int, Symbol)]) = {
      tuples flatMap {tuple => List.fill(tuple._1)(tuple._2)}
    }
    assert(decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) == List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  }

  test("P13 (**) Run-length encoding of a list (direct solution).") {
    def encodeDirect(list: List[Symbol]): List[(Int, Symbol)] = {
      if (list isEmpty) Nil
      else {
        val (packed, rest) = list span {_ == list.head}
        (packed length, packed.head) :: encodeDirect(rest)
      }
    }
    assert(encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) == List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
  }

  test("P14 (*) Duplicate the elements of a list.") {
    def duplicate(list: List[Symbol]) = {
      list flatMap {e=>List(e,e)}
    }
    assert(duplicate(List('a, 'b, 'c, 'c, 'd)) == List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd))
  }

  test("P15 (**) Duplicate the elements of a list a given number of times.") {
    def duplicateN(n : Int, list: List[Symbol]) = {
      list flatMap {List.fill(n)(_)}
    }
    assert(duplicateN(3, List('a, 'b, 'c, 'c, 'd)) == List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))
  }

  test("P16 (**) Drop every Nth element from a list.") {
    def drop(n : Int, list: List[Symbol]) = {
      list.sliding(n, n) flatMap {x => if (x.length == n) x.init else x} toList
    }
    assert(drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
  }
}

class HorribleException extends RuntimeException
