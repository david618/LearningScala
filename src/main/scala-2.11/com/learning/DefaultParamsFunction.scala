package com.learning

/**
  * Created by davi5017 on 3/7/2016.
  */
object DefaultParamsFunction {

  def main(args: Array[String]): Unit = {
    println("Returned Value: " + addInt())
  }

  def addInt(a:Int=5, b:Int=7) : Int = {
    a+b
  }
}
