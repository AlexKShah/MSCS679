//Alex Shah
//MSCS 679 - Lab 6
//2/19/18
package lab6

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global

object ParallelGLEstimator extends App {
  val MAX = Int.MaxValue
  val RANGE = 1000000L
  val numberPartitions = (MAX.toDouble / RANGE).ceil.toInt

  def calcPi(low: Long, high: Long, max: Int): Double = {
    var index: Long = low
    var sum = 0.0
    while(index <= high && high != MAX) {
      val one = if ((index & 1) == 0) 4.0 else -4.0
      sum += one / ((2.0 * index) + 1.0)
      index += 1L
    }
    sum
  }
  val t0 = System.nanoTime()

  val futures = for (i <- 0L until numberPartitions) yield Future {
    val low: Long = i * RANGE + 1
    val high: Long = MAX.toLong min (i + 1 * RANGE)
    calcPi(low, high, MAX)
  }

  val pi = futures.foldLeft(0.0) { (sum, future) =>
    import scala.concurrent.duration._
    val result = Await.result(future, 100 seconds)
    sum+result
  }

  val t1 = System.nanoTime()
  val dt = (t1 - t0) / 1000000000.0
  println("cores = " + (Runtime.getRuntime.availableProcessors())/2)
  println("Pi = " + f"$pi%2.2f")
  println("dt = " + f"$dt%2.2f")
}
