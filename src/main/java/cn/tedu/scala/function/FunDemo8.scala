package cn.tedu.scala.function

object FunDemo8 {
    // 高阶函数
    // 定义一个函数，传入三个整数，打印较大的两个整数的和，并且在有需求的时候获取较小的数字
    def sum(x: Int, y: Int, z: Int) = {
        def min() = {
            var min = if (x < y) {
                if (x < z) x else z
            } else {
                if (y < z) y else z
            }
            min
        }

        println(x + y + z - min)
        //返回min函数本身，此时不代表执行了min函数
        min _
    }

    def main(args: Array[String]): Unit = {
        var str = "abc"
        //获取到的返回值是一个函数
        var f = sum(3, 4, 6)
        println(f)
        println(f())
        var result = sum(3, 5, 1)()
        println(result)
    }
}
