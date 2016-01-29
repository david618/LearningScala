package com.learning

import com.learning.ChecksumAccumulator._

/**
  * Created by david on 1/29/2016.
  */
object Summer {

  /*
    This object uses a main function instead of extends App
    It also imports the ChecksumAccumulator Class.
    To set command args in IntelliJ menu Run -> Edit Configurations.
   */

  def main(args: Array[String]) {
    for (arg <- args)
      println(arg +": "+ calculate(arg))
  }
}
