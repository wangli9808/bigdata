package cn.tedu.scala.grammar

object OperatorDemo {
    def main(args: Array[String]): Unit = {
        var i = 5
        var j = 7
        //在scala中本质上是将所有的运算符封装成了函数
        var sun = i.+(j)
        //当调用函数的时候，如果只有一个参数，则省略。（）不写
        var sum2 = i + j

        i += 1
        println(i)

        //如果出现 . 表示调用方法，优先计算
        println(3 * 5 + 7) //22
        println(3 * 5.+(7)) //36
        println(3.+(5).*(7)) //56

        var str: String = "*"
        println(str.*(5))

        var name = "lily"
        var age = 15
        println("name = " + name + ", age = " + age)
        println(s"name = ${name},age = ${age}")


        // 赋值运算
        var m: Int = 3
        var n: Int = 5

        // 在Scala中，不支持连等运算
        // 先计算赋值运算i=j，将赋值运算的结果赋值给k
        // 赋值是没有结果的
        // k的值是无值
        // Unit表示无值类型
        var k: Unit = m = n;
        println(k)
    }
}
