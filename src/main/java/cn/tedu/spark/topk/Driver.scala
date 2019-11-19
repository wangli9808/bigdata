package cn.tedu.spark.topk

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Driver {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("topk")

    val sc = new SparkContext(conf)

    val data = sc.textFile("d://ysq/data/topk.txt", 2)

    //--RDD[String:line]->RDD[String:word]->RDD[(String,Int):(word,1)]
    //--->ReduceByKey->按频次降序->take(3)

    val result = data.flatMap { line => line.split(" ") }
      .map { word => (word, 1) }
      .reduceByKey {
        _ + _
      }

    //val top3=result.sortBy{case(word,count)=> -count}.take(3)

    val top3 = result.top(3) {
      Ordering.by { x => x._2 }
    }

    top3.foreach {
      println
    }
  }
}
