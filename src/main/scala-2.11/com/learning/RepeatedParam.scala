package com.learning

/**
  * Created by davi5017 on 3/7/2016.
  */
object RepeatedParam {
  def main(args: Array[String]): Unit = {
    printStrings("Hello","Scala","Ptyhon")
  }

  def printStrings(args:String*) = {
    var i: Int = 0
    for(arg <- args) {
      println("Arg value[" + i + "] = " + arg)
      i += 1
    }
  }
}
