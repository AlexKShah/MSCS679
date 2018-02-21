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
  val t0 = System.nanoTime()

  val futures = for (k <- 0L until numberPartitions) yield Future {
    val low: Long = k * RANGE + 1
    val high: Long = MAX.toLong min (k + 1) * RANGE

    val partialpi = (low to high).foldLeft(0.0) { (sum, n) =>
      val four = if ((n & 1) == 0) 4 else -4
      sum + four / ((2.0 * n) + 1)
    }
    partialpi
  }

  val totalpi = futures.foldLeft(4.0) { (sum, future) =>
    import scala.concurrent.duration._
    sum + Await.result(future, 100 seconds)
  }

  val t1 = System.nanoTime()
  val dt = (t1 - t0) / 1000000000.0
  println("cores = " + (Runtime.getRuntime.availableProcessors()) / 2)
  println("Pi = " + totalpi)
  println("dt = %6.2f".format(dt))
}

//cores = 4
//Pi = 3.1415926531240608
//dt =  14.70