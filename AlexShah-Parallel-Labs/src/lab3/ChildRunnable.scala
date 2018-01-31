package lab3

class ChildRunnable(no: Int) extends Runnable {
  def run = {
    println("child: " + no + ", " + Thread.currentThread.getId + ". ")
  }
}
