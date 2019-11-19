package cn.tedu.spark.maxmin

import org.apache.spark.{SparkConf, SparkContext}

object Driver02 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("maxmin")
    val sc = new SparkContext(conf)
    val data = sc.textFile("e://ysg/data/MaxMin.txt", 2)
    //--RDD[String:line]->RDD[String:女性行数据]->按身高降序->take(1)
    val r1 = data.filter { line => line.split(" ")(1).equals("F") }.sortBy { line => -line.split(" ")(2).toInt }.take(1)
    r1.foreach {
      println
    }
  }
}
