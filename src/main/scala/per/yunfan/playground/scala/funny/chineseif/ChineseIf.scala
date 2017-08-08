package per.yunfan.playground.scala.funny.chineseif

/**
  * 使用Scala模拟中文if判断
  */
object ChineseIf extends App {

  /**
    * 汉化True和False
    */
  object 布尔 {
    val 真 = true
    val 假 = false
  }

  /**
    * 否则方法封装类
    *
    * @param isRun 是否执行Else的代码
    */
  class Else(isRun: Boolean) {
    /**
      * Else方法
      *
      * @param action Else执行的语句块
      */
    def 否则(action: => Unit): Unit = if (isRun) action
  }

  /**
    * If方法
    *
    * @param test 判断条件
    * @param op   为真时执行的语句块
    * @return Else对象，返回此对象才可跟着否则方法
    */
  def 如果(test: Boolean)(op: => Unit): Else = {
    if (test) op
    new Else(!test)
  }

  /**
    * println的汉化版
    *
    * @param value 打印的值
    */
  def 打印(value: Any): Unit = println(value)

  //测试代码
  如果(布尔.真) {
    打印("真")
  } 否则 {
    打印("假")
  }
}