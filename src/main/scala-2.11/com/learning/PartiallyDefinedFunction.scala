package com.learning

import java.util.Date

/**
  * Created by davi5017 on 3/7/2016.
  */
object PartiallyDefinedFunction {

  def main(args: Array[String]): Unit = {
    val date = new Date
    val logWithDateBound = log(date, _ : String)

    logWithDateBound("Message 1")
    Thread.sleep(1000)
    logWithDateBound("Message 2")
    Thread.sleep(1000)
    logWithDateBound("Message 3")
    Thread.sleep(1000)

  }

  def log(date: Date, message: String) = {
    println(date + "----" + message)
  }
}
