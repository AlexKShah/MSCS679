package lab2

object SeqMultAdder extends App {

  val nums = List(1, 3, 4, 5, 12, 2, 7, 9, 7)

//  val f = { n: Int => println(n) }
//  nums.foreach(f)
//  def f(n: Int): Unit = println(n)

  println("nums:")
  nums.foreach(println(_))

  println("odds:")
  val odds = nums.filter { _%2 != 0 }
  odds.foreach {n: Int => println(n)}

  println("sum of 2 times odds")
  val total = odds.foldLeft(0) ((sum,nums) => sum+2*nums)
  println(total)
}
