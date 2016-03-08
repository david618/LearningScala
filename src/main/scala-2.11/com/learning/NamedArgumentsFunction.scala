package com.learning

/**
  * Created by davi5017 on 3/8/2016.
  */
object NamedArgumentsFunction {

  def main(args: Array[String]): Unit = {
    printInt(b=5, a=7)
  }

  def printInt(a: Int, b: Int) = {
    println("Value of a : " + a);
    println("Value of b : " + b);
  }
}
