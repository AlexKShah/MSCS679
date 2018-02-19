//Alex Shah
//MSCS 679 - Lab 5
//2/16/18
package lab5

object GLEstimator extends App {
  val t0 = System.nanoTime()

  val pi = (0 until Int.MaxValue).foldLeft(0.0) { (sum, n) =>
    val one = if ((n & 1) == 0) 4 else -4
    sum + one / ((2.0 * n) + 1)
  }

  val t1 = System.nanoTime()
  val dt = (t1 - t0) / 1000000000.0

  println("Pi = " + f"$pi%2.2f")
  println("dt = " + f"$dt%2.2f")
}
