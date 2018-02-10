package lab5

object GLEstimator extends App {
  val t0 = System.nanoTime()

  println("Pi = " +
    (0 until Int.MaxValue).foldLeft(0.0) { (sum, n) =>
      sum + 4.0 * math.pow(-1, n) / ((2.0 * n) + 1)
    })

  val t1 = System.nanoTime()
  val dt = (t1 - t0) / 1000000000.0

  println("dt = " + dt)
}
