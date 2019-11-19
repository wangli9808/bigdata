package cn.tedu.spark.average

import org.apache.spark.{SparkConf, SparkContext}

object Driver {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("average")
    val sc = new SparkContext(conf)
    val data = sc.textFile("e://ysg/data/average.txt", 2)
    //--RDD[String:line]->RDD[int:第二列数字]->sum/count
    val r1 = data.map { line => line.split(" ")(1).toInt }
    val average = r1.sum / r1.count
    println(average)
  }
}
