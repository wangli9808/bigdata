package cn.tedu.scala.grammar

import scala.io.StdIn

object LoopDemo {
    def main(args: Array[String]): Unit = {

        //输入一个大于5的数字
        //    var i:Int = StdIn.readInt()
        //    var result:Unit = while (i<=5) i = StdIn.readInt()
        //    println(result)

        //打印1-10
        //    var j = 1
        //    while (j <= 10) println(j)

        // i <- start to end
        // 默认每次增加一个步长
        //    for (i <- 1 to 10) println(i)
        //    for (i <- 0.to(10,2)) println(i)

        //遍历数组
        //    var arr: Array[Int] = Array[Int](1, 2, 3, 4, 5, 6, 7, 8, 9)
        //    for (i <- 0 until arr.length)
        //      println(arr(i))

        //    var result: Unit = for (i <- 0 to 5) println(i)


        // 构建n^2的集合
        // (1,4,9,16,25)
        // 利用yield将循环的结果返回，放入一个Vector集合中
        //    var result = for (i <- 1 to 5) yield i * i
        //    println(result)

        // 打印100以内能整除5而不能整除7
        //        for (i <- 0.to(100, 5))
        //            if (i % 7 != 0)
        //                println(i)

        //等价于守卫循环
        //        for (i <- 0.to(100, 5) if (i % 7 != 0))
        //            println(i)

        //        for (i <- 1 to 5)
        //            for (j <- 1 to 5)
        //                println(i + "," + j)

        //        for (i <- 1 to 5; j <- 1 to 5)

        // for{}{}中的第一个{}表示循环条件，后一个{}包含的是循环体
        //        for {
        //            i <- 1 to 5
        //            j <- 1 to 5
        //        } {
        //            println(i + "," + j)
        //        }




    }
}
