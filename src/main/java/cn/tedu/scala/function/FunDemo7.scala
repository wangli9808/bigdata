package cn.tedu.scala.function

object FunDemo7 {
    // 高阶函数
    // 打印两个整数的计算结果
    // 第三个需要表示这俩整数的计算过程 - 意味着第三个参数应该传入一个函数
    // 并且这个函数应该是计算俩整数，然后返回一个整数
    def printResult(x: Int, y: Int, f: (Int, Int) => Int) = println(f(x, y))

    def main(args: Array[String]): Unit = {
        printResult(3, 4, (x: Int, y: Int) => x + y)
        printResult(3, 4, (x: Int, y: Int) => x * y)
        // 匿名函数在传递的时候，因为参数类型是已知的，所以匿名函数的参数类型是可以省略的
        printResult(3, 4, (a, b) => a * b)
        // 在匿名函数中，参数只使用了一次，可以使用_代替， _出现的顺序依次表示参数的顺序
        printResult(5, 8, _ + _);
    }
}
