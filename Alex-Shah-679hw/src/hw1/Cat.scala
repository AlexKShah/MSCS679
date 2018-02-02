//Alex Shah
//MSCS679
//HW1
package hw1

object Cat extends App {
  val tweet =
    "If a cat can kill a rat in a minute, how long would it be killing 60,000 rats? " +
      "Ah, how long indeed! My private opinion is that the rats would kill the cat. " +
      "~Lewis Carroll, on the advantages of parallelism"

  println("1. " +
    tweet.length()
  )

  println("2. " +
    tweet.foldLeft(0) { (sum, n) => sum + 1 }
  )

  println("3. " +
    tweet.count(_ => true)
  )

  println("4. " +
    tweet.count(_ == ' ')
  )

  println("5. " +
    tweet.count(_ == '.') + tweet.count(c=> c == ','|| c == '?'|| c == '~'|| c == '!')
  )

  println("6. " +
    tweet.split(' ').count(c => !c.exists(_.isUpper))
  )

  println("7. " +
    tweet.split(' ').filter(c => c.exists(_.isUpper)).toList
  )

  print("8. ")
  println(
    tweet.split(' ').map { w => w.map { c => print((c+1).toChar) } }
  )

  val cipher = for (c: Char <- tweet.filterNot(_.isWhitespace).map(c => (c+1).toChar )) yield c
  println("9. " + cipher)

  println( "10. " +
    tweet.toLowerCase().foldLeft[Map[Char, Int]](Map.empty)((m, c) => m + (c -> (m.getOrElse(c, 0) + 1))).toList.sortBy(_._2).reverse
  )

}