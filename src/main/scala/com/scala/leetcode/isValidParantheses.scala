package com.scala.leetcode

import scala.collection.mutable

object isValidParantheses extends App {
  def isValid(s: String): Boolean = {
    val paratheses = Map('(' -> ')', '[' -> ']', '{' -> '}')
    val stack = mutable.Stack[Char]()
    for(ch <- s) {
      if(paratheses.contains(ch)) {
        stack.push(ch)
      } else if(stack.isEmpty) return false
        else if(!paratheses.get(stack.pop).contains(ch)) return false
    }
    stack.isEmpty
  }

  println(isValid("(){}"))
  println(isValid("(]"))
}

