package per.yunfan.playground.scala.functional

/**
  * 一个简单的Y-组合子实现
  */
object YCombiner extends App {

  /**
    * Y-组合子的实现函数
    *
    * @param function 需要被递归执行的函数
    * @tparam T 函数递归元素类型
    * @return 可递归执行的函数
    */
  def Y[T](function: (T => T) => (T => T)): (T => T) = function(Y(function))(_)

  //计算斐波那契数列测试代码
  val fibonacci = Y[Int] { f => n => if (n == 0) 0 else if (n == 1) 1 else f(n - 2) + f(n - 1) }

  (0 to 5) foreach { i => println(fibonacci(i)) }

  //println(fibonacci(5))

}
