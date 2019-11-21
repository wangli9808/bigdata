package cn.tedu.scala.function

import java.io.{File, IOException}

object FunDemo5 {

    def main(args: Array[String]): Unit = {
        // 函数中可以定义函数
        // 输入价格和折扣，计算折后价格
        // 隐式参数
        println(realPrice(25, 0.8))
        println(realPrice(34, 0.8))

        def realPrice(i: Int, d: Double) = i * d
    }

    //这个注解没有强制性，只是提示
    @throws("IOException")
    def read(file: File) = {
        if (!file.exists())
            throw new IOException
    }
}
