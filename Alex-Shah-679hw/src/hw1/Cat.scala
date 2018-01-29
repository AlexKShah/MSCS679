package hw1

object Cat extends App {
  val tweet =
    "If a cat can kill a rat in a minute, how long would it be killing 60,000 rats? " +
    "Ah, how long indeed! My private opinion is that the rats would kill the cat. " +
    "~Lewis Carroll, on the advantages of parallelism"
  println("1. " + tweet.length())
  println("2. " + tweet.foldLeft(0) { (sum, n) => sum + 1 })
  println("3. " + tweet.count( _=> true))
  println("4. " + tweet.count( _== ' '))
  print("5. ")
  println( tweet.count( _== '.' ) + tweet.count( _== ',' ) + tweet.count( _== '?' ) + tweet.count( _== '~' ) + tweet.count( _== '!' ) )
  println("6. "  )
  println("7. "  )
  println("8. "  )
  println("9. "  )
  println("10. "  )
 }