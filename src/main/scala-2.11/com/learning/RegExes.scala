package com.learning

/**
  * Created by davi5017 on 3/8/2016.
  */
object RegExes {
  def main(args: Array[String]): Unit = {
    val pattern = "a[a-z]".r
    val str = "Scala is Scalable and cool"

    val f = pattern findAllIn str
    for (a <- f) {
      println(a)
    }
  }
}
