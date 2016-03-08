package com.learning

/**
  * Created by davi5017 on 3/7/2016.
  */
object HelloWorld2 {
  def main(args: Array[String]): Unit = {
    println("Hello World!")

    val (myVar1: Int, myVar2: String) = Pair(40, "Foo")
    val (myVar3, myVar4) = (40, "Foo")

    println(myVar3)
  }
}
