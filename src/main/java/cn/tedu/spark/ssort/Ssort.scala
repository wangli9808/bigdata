package cn.tedu.spark.ssort

/**
 * 用于封装ssort.txt中两列数据
 */
class Ssort(val col1: String, val col2: Int) extends Ordered[Ssort] with Serializable {

  /*
   * 用于定义排序比较规则
   * 本案例:先按第一列做升序排序
   * 再按第二列做降序排序
   */
  def compare(that: Ssort): Int = {
    //--第一列升序
    val result = this.col1.compareTo(that.col1)

    if (result == 0) {
      //--第二列降序
      that.col2.compareTo(this.col2)
    } else {
      result
    }
  }
}
