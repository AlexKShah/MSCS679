package lab3

object ParentWithThread extends App {
  val child = new Thread(new ChildThread(0))

  child.start

  val numCores = Runtime.getRuntime.availableProcessors

  val numThreads = Thread.activeCount()

  val id = Thread.currentThread.getId

  println("Parent: " + numCores + ", " + numThreads + ", " + id)

  child.join
}
