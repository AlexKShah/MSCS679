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
  println("6. " + tweet.split(' ').count(c => !c.exists(_.isUpper ) ) )
  println("7. " + tweet.split(' ').count(c =>  c.exists(_.isUpper ) ) )
  print("8. " )
  print( tweet.split(' ').foreach{
    w => w.foreach {
      c => print( (c+1).toChar )
    }
  } )
  print("\n")
  val cipher = for (c:Char <- tweet.filterNot(_.isWhitespace).map(c => (c.toInt+1).toChar)) yield c
  println("9. " +  cipher)
  //println("10. "
    //val tweetchars = for (c <- tweet.toLowerCase()) yield c
    //tweetchars.foldLeft(Map.empty[Char,Int]) { c, n =>  } )
  println((tweet.toLowerCase().groupBy(identity).mapValues(_.length)).toList.sortBy(_._2).reverse)
 }