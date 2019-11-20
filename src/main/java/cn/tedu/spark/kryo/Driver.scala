package cn.tedu.spark.kryo

import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

object Driver {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("kryo")
      .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
      .set("spark.kryo.registrator", "cn.tedu.spark.kryo.MyKryoRegister")
    val sc = new SparkContext(conf)
    val p1 = new Person("tom", 23)
    val p2 = new Person("lily", 43)
    val r1 = sc.makeRDD(List(p1, p2))
    r1.persist(StorageLevel.MEMORY_ONLY_SER)
    r1.collect
    r1.unpersist()
  }
}
