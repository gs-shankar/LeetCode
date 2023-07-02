package com.scala.leetcode

import scala.annotation.tailrec
import scala.collection.mutable

object twoSum extends App {
  /*def twoSum(n: Array[Int], t: Int): Array[Int] = {
    n.zipWithIndex.filter(x => n.patch(x._2, Nil, 1).contains(t - x._1))
      .map(_._2)
  }*/
  def twoSum(n: Array[Int], t: Int): Array[Int] = {
    @tailrec
    def twoSum(index: Int, previous: Map[Int, Int]): Array[Int] =
      previous.get(t - n(index)) match {
      case Some(previousIndex) => Array(previousIndex, index)
      case _ => twoSum(index + 1, previous ++ Map(n(index) -> index))
    }
    twoSum(0, Map.empty)
  }
}
