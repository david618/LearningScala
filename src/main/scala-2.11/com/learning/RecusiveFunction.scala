package com.learning

/**
  * Created by davi5017 on 3/8/2016.
  */
object RecusiveFunction {

  def main(args: Array[String]): Unit = {
    for (i <- 1 to 10) {
      println("Factorial of " + i + " = " + factorial(i))
    }
  }
  def factorial(n: BigInt): BigInt = {
    if (n <= 1)
      1
    else
      n*factorial(n-1)
  }
}
