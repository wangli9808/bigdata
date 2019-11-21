package cn.tedu.scala.grammar

object VariableDemo {
    def main(args: Array[String]): Unit = {
        // int i = 10;
        // 所有的变量都是通过var关键字来定义
        // 变量定义格式：
        // 1. var 变量名:数据类型  = 值
        //    var str: String = "abc"
        //    var i: Int = 5
        //    var d: Double = 3.25

        // 2. var 变量名 = 值
        // 这种定义方式在编译的时候自动推导数据类型
        //    var i2 = 3

        /*
         * 在Java中，变量可以先声明后赋值
         * int i;
         * i = 5
         */
        // 在Scala中，变量必须定义的时候赋值
        //    var c:Char;
        //    c = 'a';

        // 虽然可以使用_定义标识符，但是不建议_作为开头
        //    var _:String = "a"
        //    var str:String = _ + _

        // 在Scala中，特殊符号可以作为标识符使用
        //    var +-*/? : String = "a"

        // 在Scala中，标识符的命名可以使用``
        //    var `a`: String = "abc"
        //    var `private`: String = "abc"
        //    var `private+`: String = "abc"
        //    println(`a`)

        //    val str: String = "d"

        // Scala中定义变量的时候支持类型的自动推导，但是如果需要使用向上造型，那么此时必须指定类型
        // 如果这样写，将自动将o推导为String类型
        //    var o = "abc";
        // 如果需要定义o是Object类型
        var o: Object = "abc"

    }
}
