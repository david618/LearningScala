package com.learning

import java.io.{IOException, FileNotFoundException, FileReader}

/**
  * Created by davi5017 on 3/8/2016.
  */
object TryCatch {
  def main(args: Array[String]): Unit = {
    try {
//      val f = new FileReader("input.txt")
      throw new IOException("Oops!!!!")
    } catch {
      case ex: FileNotFoundException => {
        println("FileNotFoundException")
      }
      case ex: IOException => {
        println("IOException")
      }
    }
  }
}
