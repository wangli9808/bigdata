package cn.tedu.spark.cache

import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

object Driver {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("cache")
    val sc = new SparkContext(conf)
    //设置检查点目录，路径可以是本地文件系统，也可以是HDFS（建议）
    sc.setCheckpointDir("hdfs://hadoop01:9000/check")
    val data = sc.textFile("e://data/topk.txt")
    //习惯上，建议将数据源RDD持久化到缓存里，避免数据恢复是产生大量磁盘I0，从而提高性能
    data.cache()
    val r1 = data.flatMap { line => line.split(" ") }
    val r2 = r1.map { word => (word, 1) }
    //习惯上将整个计算链中间位置RDD持久化到内存中
    //persist()和cdche()是默认MEMORY_ONLY
    //persist()也可以指定到其他级别
    //RDD缓存机制生效的前提，必须触发执行操作
    r2.persist(StorageLevel.MEMORY_AND_DISK)
    //设置检查点
    r2.checkpoint()
    val r3 = r2.reduceByKey(_ + _)
    //执行action操作
    r3.foreach {
      println
    }
    //action执行完毕，一定记得清除内存
    data.unpersist()
    r2.unpersist()
  }
}
