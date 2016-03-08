package com.learning

/**
  * Created by davi5017 on 3/8/2016.
  */
object AnonymousFunctions {
  def main(args: Array[String]): Unit = {
    val inc = (x:Int) => x+1

    println(inc(7))
    println(inc(10))

    val mul = (x:Int, y:Int) => x*y

    println(mul(3,4))

    val userDir = () => { System.getProperty("user.dir")}

    println(userDir())

  }
}
