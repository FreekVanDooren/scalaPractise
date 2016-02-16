package practise.chapter11extra

class Exercise4BinarySortedTree extends org.scalatest.FunSuite {

  object Exercise {
    //A sorted tree where all values in the left branch are lower than the current value.
    //And all values in the right branch are higher
    abstract class Tree(value: Int) {
      def contains(v: Int): Boolean = ???
    }
    case class Branch(value: Int, left: Tree, right: Tree) extends Tree(value)
    case class Leaf(value: Int) extends Tree(value)

    def createTree(values: List[Int]): Tree = ???
  }

  import Exercise._

  test("createTree") {
    assert(createTree(List(1)) === Leaf(1))
    assert(createTree(List(1, 2, 3)) === Branch(2, Leaf(1), Leaf(3)))
  }

  test("contains") {
    val tree123 = Branch(2, Leaf(1), Leaf(3))
    assert(tree123.contains(1))
    assert(tree123.contains(2))
    assert(tree123.contains(3))
    assert(!tree123.contains(0))
    assert(!tree123.contains(4))
  }
}