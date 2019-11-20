package cn.tedu.spark.invert

import org.apache.spark.{SparkConf, SparkContext}


object Driver {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("invert")
    val sc = new SparkContext(conf)
    //将指定目录下的所有文件读取到一个RDD里
    //RDD【（filepath，fileText）】
    //要求：返回倒排索引表
    //文档名需用从路径中获取，从文档类容获取单词，先按\r\n，切出行数据，再按照空格切单词
    //(scala,doc1)
    //(hello,doc1,doc2)
    val data = sc.wholeTextFiles("e://data/inverted/*")
    //    data.foreach{println}
    val r1 = data.map { case (filePath, fileText) =>
      val fileName = filePath.split("/").last.dropRight(4)
      (fileName, fileText)
    }
    val r2 = r1.flatMap { case (fileName, fileText) =>
      fileText.split("\r\n").flatMap { line => line.split(" ") }.map { word => (word, fileName) }
    }
    val r3 = r2.groupByKey.map { case (word, buffer) => (word, buffer.toList.distinct.mkString(",")) }
    r3.foreach {
      println
    }
  }
}
