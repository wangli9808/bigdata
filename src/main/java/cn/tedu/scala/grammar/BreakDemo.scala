package cn.tedu.scala.grammar

object BreakDemo {
  def main(args: Array[String]): Unit = {
    breakable(
      for (i <- 1 to 6) {
        if (i % 3 == 0)
        // 如果某个方法没有参数，那么在调用的时候可以省略()
        // break()
        // 等价
          break
        println(i * i)
      })
    println("循环中止~~~")
  }
}
