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

  //TODO #7 Words themselves, not the count

  //val words = for (words <- tweet.split(' ').exists(_.isUpper )  } ) yield words
  //returns garbage
  //println("7. " + words )

  print("8. " )
  print( tweet.split(' ').foreach{ w => w.foreach { c => print( ((c.toInt+1)%128).toChar )} } )
  print("\n")

  //val cipher = for (c:Char <- foreach{ w => w.foreach { c => print( ((c.toInt+1)%128).toChar )} } ) yield c
  val cipher = for (c:Char <- tweet.filterNot(_.isWhitespace).map(c => ((c.toInt+1)%128).toChar)) yield c
  println("9. " + cipher)

  //TODO #10 need to follow instructions and use a real Map
  println("10. " + tweet.toLowerCase().groupBy(c => c).mapValues(tweet => tweet.length).toList.sortBy( n => n._2).reverse)

//  words.map {
//    word => word.map {
//      c => something
//    }
//  }

//tweet.foldLeft(Map[String,Int]()) { (m, c) =>
//    //m initially is an empty map, m is the entire map
//    val count = m(c)
//    //or else: if you haven't seen it yet, give me 0
//    m.getOrElse(c, 0)
//    m(c) = count + 1
//  }.toList.sortWith { (a.b) => }

}