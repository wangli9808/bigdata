package cn.tedu.scala.function

object FunDemo4 {
    //没有public关键字
    //只要不指定，默认是公开的
    def max(i: Int, j: Int) = if (i > j) i else j

    //输入一串整数，求和，可以用 * 定义可变参数
    def sum(arr: Int*) = {
        var sum = 0;
        for (i <- 0 until arr.length)
            sum += arr(i)
        sum
    }

    def main(args: Array[String]): Unit = {
        println(max(1, 3))
        println(sum(1, 2, 3))
    }
}
