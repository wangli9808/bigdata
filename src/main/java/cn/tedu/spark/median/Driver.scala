package cn.tedu.spark.median

import org.apache.spark.{SparkConf, SparkContext}

object Driver {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("median")
    val sc = new SparkContext(conf)
    val data = sc.textFile("e://ysg/data/median.txt")
    //--RDD[String:line]->RDD[Int:num]->排序->获取中位数位置
    val r1 = data.flatMap { line => line.split(" ") }.map { num => num.toInt }.sortBy(num => num)
    val medianPos = (r1.count() + 1) / 2
    //val median = r1.collect()(medianPos.toInt-1)
    val median = r1.take(medianPos.toInt).last
    println(median)
  }
}
