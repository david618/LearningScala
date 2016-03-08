package com.learning

/**
  * Created by davi5017 on 3/8/2016.
  */
object CurringFunctions {

  def main(args: Array[String]): Unit = {
    def strcat(s1: String)(s2: String) = s1 + s2
    def strcat2(s1: String) = (s2:String) => s1 + s2

    println(strcat("a")("b"))
    println(strcat2("a")("b"))

    def strcat3(s1: String)(s2: String)(s3: String) = s1 + s2 + s3

    println(strcat3("a")("b")("c"))

  }
}
