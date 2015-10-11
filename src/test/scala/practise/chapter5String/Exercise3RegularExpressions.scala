package practise.chapter5String

//Read http://www.tutorialspoint.com/scala/scala_regular_expressions.htm
class Exercise3RegularExpressions extends org.scalatest.FunSuite {
  object Exercise {
    def isDate(s: String): Boolean = ???

    def findDate(s: String): Option[String] = ???
  }
  //startAnswer
  object Answer {
    val dateregex = """(\d\d\d\d)-(\d\d)-(\d\d)"""
    def isDate(s: String): Boolean = s.matches(dateregex)

    def findDate(s: String): Option[String] = dateregex.r.findFirstIn(s)
  }
  import Answer._
  //endAnswer

  test("isDate") {
    assert(isDate("2011-11-11"))
    assert(!isDate("11-11-11"))
    assert(!isDate(""))
    assert(!isDate("bla"))
    assert(!isDate("bla-die-bla"))
  }

  test("findDate") {
    assert(findDate("it happened on 2011-11-11") === Some("2011-11-11"))
    assert(findDate("it didn't happen") === None)
  }


}
