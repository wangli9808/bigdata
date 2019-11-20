package cn.tedu.spark.wordcount

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Driver {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("spark://hadoop01:7077").setAppName("wordcount")

    val sc = new SparkContext(conf)

    val data = sc.textFile("hdfs://hadoop01:9000/1.txt", 3)

    val result = data.flatMap {
      _.split(" ")
    }.map {
      (_, 1)
    }.reduceByKey {
      _ + _
    }

    result.saveAsTextFile("hdfs://hadoop01:9000/result02")
  }
}
