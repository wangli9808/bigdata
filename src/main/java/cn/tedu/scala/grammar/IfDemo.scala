package cn.tedu.scala.grammar

import scala.io.StdIn

object IfDemo {
  def main(args: Array[String]): Unit = {
    var i: Int = StdIn.readInt()
    // 任何结构都可以有结果
    // 如果if判断，则结果为Int
    // 如果if判断不成立，则结果为Unit
    val result: AnyVal = if (i < 5) {
      println("~~~")
      5 //Int
    }

    //------------------------------------------

    // 如果变量强制定义为Unit类型，那么这个类型可以赋任何值，赋值无效
    var r: Unit = 4
    println(r)

    //-------------------------------------------

    //输入分数获取等级
    var score: Int = StdIn.readInt()
    var result1: String = if (score >= 60) "合格" else "不合格"
    println(result1)
    var c :Char = if (score>=90) 'A' else if (score>=80) 'B' else 'C'
    println(c)
  }
}
