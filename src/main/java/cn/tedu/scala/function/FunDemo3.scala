package cn.tedu.scala.function

object FunDemo3 {
    // 获取1-100之间的随机整数
    //  def rand(): Int = {
    //    return (Math.random() * 100 + 1).toInt
    //  }
    def rand() = (Math.random * 100 + 1).toInt

    //  def rand = (Math.random * 100 + 1).toInt

    def main(args: Array[String]): Unit = {

        // 如果一个函数在定义的时候没有参数，那么调用的时候可以省略掉()
        //    println(rand())
        // 如果函数在定义的时候没有()，那么调用的时候必须没有()
        println(rand)

        var str = "123"
        var i = str.toInt

    }
}
