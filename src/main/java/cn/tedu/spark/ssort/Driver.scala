package cn.tedu.spark.ssort

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Driver {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("ssort")

    val sc = new SparkContext(conf)

    val data = sc.textFile("d://ysq/data/ssort.txt")

    //--RDD[String:line]->RDD[(Ssort,line)]->sortByKey 按对象的compare方法排序
    val r1 = data.map { line =>
      val info = line.split(" ")
      val col1 = info(0)
      val col2 = info(1).toInt
      (new Ssort(col1, col2), line)
    }

    val r2 = r1.sortByKey(true).map { x => x._2 }


    r2.foreach {
      println
    }


  }
}
