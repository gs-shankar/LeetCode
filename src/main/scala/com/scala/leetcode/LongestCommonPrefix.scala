package com.scala.leetcode

/*
Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
*/

import scala.annotation.tailrec

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
