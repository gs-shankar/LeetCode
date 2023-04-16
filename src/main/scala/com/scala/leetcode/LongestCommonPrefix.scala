package com.scala.leetcode

object LongestCommonPrefix extends App {
  def longestCommonPrefix1(words: Array[String]): String = {
    val minVal = words.minBy(_.length).length
    words
      .map(_.toList.take(minVal))
      .toList
      .transpose
      .takeWhile(lst => lst.forall(_ == lst.head))
      .map(_.head)
      .mkString
  }

  def longestCommonPrefix2(words: Array[String]): String = {
    words.fold(words.head) {
      case(acc, x) =>
        var newAcc = acc
        while(!x.startsWith(newAcc)) {
          newAcc = newAcc.dropRight(1)
        }
        newAcc
    }

  }

  println(longestCommonPrefix1(Array("flower", "flat", "flight")))
  println(longestCommonPrefix2(Array("flower", "flat", "flight")))
  println(longestCommonPrefix1(Array("Alower", "Blat", "Clight")))
  println(longestCommonPrefix2(Array("", "flat", "flight")))

}
