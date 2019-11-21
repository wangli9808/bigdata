package cn.tedu.scala.function

/**
 * 函数定义格式
 */
object FunDemo1 {
    def main(args: Array[String]): Unit = {
        //求和
        def sum(i: Int, j: Int): Int = {
            return i + j
        }

        //默认将函数最后一行计算结果作为返回值
        def sum1(i: Int, j: Int): Int = {
            i + j
        }

        //利用函数最后一行可以推导计算结果类型，此时可以省略返回值类型
        def sum2(i: Int, j: Int) = {
            i + j
        }

        //函数只有一行，省略{}
        def sum3(i: Int, j: Int) = i + j

        //获取1-100间的随机整数
        def rand = (Math.random() * 100 + 1).toInt

        def m = "abc"
    }
}
