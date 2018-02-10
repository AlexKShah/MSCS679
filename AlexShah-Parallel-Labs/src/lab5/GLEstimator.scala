package lab5

object GLEstimator extends App {
  val t0 = System.nanoTime()

  println("Pi = " + (0 until Int.MaxValue).foldLeft(0L) { (sum,n) => sum+((math.pow(-4,n).toLong)/(2L*n+1)) } )

  val t1 = System.nanoTime()

  val dt = t1-t0*1000000000

  println("dt = " + dt)
}
