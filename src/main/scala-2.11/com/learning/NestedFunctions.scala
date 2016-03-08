package com.learning

/**
  * Created by davi5017 on 3/7/2016.
  */
object NestedFunctions {

  def main(args: Array[String]): Unit = {
    println(factorial(7))
  }

  def factorial(i: Int): Int = {
    def fact(i: Int, accumulator: Int): Int = {
      if (i <= 1)
        accumulator
      else {
        println(accumulator)
        fact(i-1, i*accumulator)
      }
    }
    fact(i,1)
  }
}
