package cn.tedu.scala.function

object FunDemo6 {
    def main(args: Array[String]): Unit = {
        //在scala中，允许定义参数时给个默认值
        def realPrice(price: Double, off: Double = 0.8) = price * off
        // 实际过程中，会将含有默认值的参数放到最后
        //            def realPrice(off: Double = 0.8, price: Double) = price * off
        println(realPrice(100))
        println(realPrice(100, 0.5))

        implicit var s = "implicit"

        // 隐式参数
        // 在函数中，隐式参数必须在参数列表的头部
        def test(implicit str: String) = println(str)

        test

        def test1(implicit str: String = "default") = println(str)
        // 如果加入()，此时表示调用这个方法，那么因为存在默认值，此时默认值会覆盖掉隐式值
        test1() // default
        // 如果不加()，此时调用过程发生变化，此时默认值不生效
        test1 // implicit
    }
}
