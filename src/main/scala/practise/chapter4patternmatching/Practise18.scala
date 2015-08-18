package practise.chapter4patternmatching

object Practise18 {
  //read: https://twitter.github.io/scala_school/basics2.html#match
  def matchInt(number: Int): String = number match {
    case 1 => "one"
    case 2 => "two"
    case x if x < 10 => "few"
    case x if x > 10 => "many"
  }
  
  def matchNumber(number: Any): String = number match {
    case x: Integer if x > 10 => "a big Integer"
    case _: Integer => "an Integer"
    case _: Double => "a Double"
    case _ => "not a number"
  }

}
