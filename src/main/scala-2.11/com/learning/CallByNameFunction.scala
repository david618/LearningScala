package com.learning

import scala.util.Random

/**
  * Created by davi5017 on 3/7/2016.
  */
object CallByNameFunction {
  def main(args: Array[String]): Unit = {
    delayed(time())
    delayed(getRndLong())
  }

  def time() = {
    println("Getting time in nano seconds")
    System.nanoTime()
  }

  def getRndLong() = {
    println("Getting Random Long")
    Random.nextLong()
  }

  def delayed(t: => Long) = {
    // Input parameter is a function that returns a long
    println("In delayed method")
    println("Param: " + t)
    t
  }
}
