package lab5

object GLEstimator extends App {
  val t0 = System.nanoTime()
  val pi = (0 until 99).foldLeft(0.0) { (sum, n) =>
      sum + 4.0 * math.pow(-1, n) / ((2.0 * n) + 1)
    }
  val t1 = System.nanoTime()
  val dt = (t1 - t0) / 1000000000.0
  println("Pi = " + f"$pi%2.2f")
  println("dt = " + f"$dt%2.2f")
}
