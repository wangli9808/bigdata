package cn.tedu.scala.grammar

import scala.io.StdIn

object LoopDemo {
  def main(args: Array[String]): Unit = {

    //输入一个大于5的数字
    var i:Int = StdIn.readInt()
    var result:Unit = while (i<=5) i = StdIn.readInt()
    println(result)

    //打印1-10
    var j = 1
    while (j <= 10) println(j)
  }
}
