val list = List(1, 2, 3)

def isEven(i: Int) = i % 2 == 0
list.filter(isEven)

list.map { number => number + 1 }

list.foreach { println(_) }
