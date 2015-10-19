val verhaal: String = "bladiebla"
val verhaal2 = "bladiebla"


val list = List(1, 2, 3)

def isEven(i: Int) = i % 2 == 0
list.filter(isEven)

list.map { number => number + 1 }

list.foreach { println(_) }


class Vierkant(lengte: Int) {
  val oppervlakte = lengte * lengte
}
val v = new Vierkant(3)

object Vierkant {
  def draai(v: Vierkant) = v
}
Vierkant.draai(v)

