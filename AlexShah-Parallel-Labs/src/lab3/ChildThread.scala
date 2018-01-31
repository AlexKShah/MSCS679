package lab3

class ChildThread(no: Int) extends Thread {
  override def run(): Unit = {
    print(no + this.getId)
  }
}
