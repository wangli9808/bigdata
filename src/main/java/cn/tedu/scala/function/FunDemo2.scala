package cn.tedu.scala.function

object FunDemo2 {
    // 在这种省略形式下，不能显式的声明return
    // 默认就将最后一行作为了结果
    def sum(i: Int, j: Int) = {
        //            return i + j
        i + j
    }

    //输入*组成的三角
    //Unit等价于java中的void
    //如果一个函数返回值为unit，也称这个函数为过程
    def printStar(row: Int): Unit = {
        for (i <- 1 to row)
            println("*" * i)
    }

    //如果返回值是unit，省略=
    def printStar1(row: Int): Unit = {
        for (i <- 1 to row)
            println("*" * i)
    }

    def main(args: Array[String]): Unit = {
        println(sum(3, 5))
        printStar1(5)
    }
}
