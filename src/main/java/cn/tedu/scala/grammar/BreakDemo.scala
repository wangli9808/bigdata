package cn.tedu.scala.grammar

// _类似于Java中的*

import scala.util.control.Breaks._

object BreakDemo {
  def main(args: Array[String]): Unit = {
    breakable {
      for (i <- 1 to 6) {
        if (i % 3 == 0)
          break()
        println(i * i)
      }
    }
    println("循环终止")
  }
}
