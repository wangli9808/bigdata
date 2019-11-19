package cn.tedu.spark.maxmin

import org.apache.spark.{SparkConf, SparkContext}

object Driver {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("maxmin")
    val sc = new SparkContext(conf)
    val data = sc.textFile("e://ysg/data/MaxMin.txt", 2)
    //--RDD[String:line]->RDD[String:男性行数据]->RDD[Int:男性身高]->max
    val r1 = data.filter { line => line.split(" ")(1).equals("M") }.map { line => line.split(" ")(2).toInt }.max
    println(r1)
  }
}
