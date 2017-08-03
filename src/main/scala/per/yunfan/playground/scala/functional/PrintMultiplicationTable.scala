package per.yunfan.playground.scala.functional

/**
  * 函数式方式打印乘法表，与per.yunfan.playground.java.functional.PrintMultiplicationTable原理相同
  */
object PrintMultiplicationTable extends App {

  // 柯里化函数，类型是： Int => Int => String => Unit
  val multiplicationTable =
    (min: Int) => //乘法表开始
      (max: Int) => //乘法表结束
        (action: String => Unit) => //调用的函数去遍历每一行
          (min to max).flatMap(num => (1 to num).map((_, num))) //产生乘法表矩阵，每次数字保存为二元组
            .map { case (a, b) => s"$a x $b = ${a * b}${if (a == b) "\r\n" else "\t"}" } //实际计算并映射为字符串
            .foreach(action)

  //实际调用测试
  multiplicationTable(1)(9)(print)
}