package cn.tedu.scala.grammar

object TypeDemo {
    def main(args: Array[String]): Unit = {
        // 隐式转换
        // 方式一：小类型转化为大类型
        var i: Int = 5
        // 如果在隐式转换的时候没有指定类型，那么变量的类型和值的类型一样
        var l: Long = i.toInt

        // 方式二：自定义隐式转换规则
        // 在Scala中，自定义转换规则本质上就是定义一个函数
        // 函数之间可以嵌套
        // TODO  隐藏函数
        // implicit表示隐藏
        // 隐藏函数
        implicit def doubleToInt(d: Double): Int = {
            return d.toInt
        }

        var d: Double = 3.5
        var i2: Int = d

        //显示转换
        //强制转换
        var i3: Int = 1.toInt
        //针对向上造型
        var o: Any = "abc"
        var str2: String = o.asInstanceOf[String]
    }
}
