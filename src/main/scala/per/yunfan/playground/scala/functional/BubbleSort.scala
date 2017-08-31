package per.yunfan.playground.scala.functional


import scala.annotation.tailrec

object BubbleSort extends App {

  //  def bubble[T](list: List[T])(implicit ordered: T => Ordered[T]): List[T] = {
  //    @tailrec
  //    def sort: List[T] => List[T] => List[T] => List[T] =
  //      raw =>
  //        now =>
  //          acc =>
  //            raw match {
  //              case first :: second :: tail => if (first > second) sort(first :: tail)(second :: now)(acc) else sort(second :: tail)(first :: now)(acc)
  //              case h1 :: Nil => if (now.isEmpty) h1 :: acc else sort(now)(Nil)(h1 :: acc)
  //              case Nil => Nil
  //            }
  //
  //    sort(list)(Nil)(Nil)
  //  }

  def bubbleSort[T](list: List[T])(implicit ordered: T => Ordered[T]): List[T] = {
    @tailrec
    def sort(input: List[T])(now: List[T])(acc: List[T]): List[T] = input match {
      case first :: second :: tail => if (first > second) sort(first :: tail)(second :: now)(acc) else sort(second :: tail)(first :: now)(acc)
      case first :: Nil => if (now.isEmpty) first :: acc else sort(now)(Nil)(first :: acc)
      case Nil => Nil
    }

    sort(list)(Nil)(Nil)
  }

  println(bubbleSort(Iterator.from(1).take(100000).toList).length)
}