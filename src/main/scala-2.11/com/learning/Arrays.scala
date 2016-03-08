package com.learning

import scala.collection.mutable.ArrayBuffer

/**
  * Created by davi5017 on 3/8/2016.
  */
object Arrays {
  def main(args: Array[String]): Unit = {
    val z = new Array[String](3)

    val z2 = Array("Mary","David","John")

    val myList = Array(1.9, 2.9,3.4, 3.5)

    for (x <- myList) {
      println(x)

    }
    //Summing elements
    var total = 0.0
    for (i <- 0 to (myList.length - 1)) {
      total += myList(i)
    }
    println("Total: " + total)

    var max = myList(0)
    for (x <- myList) {
      if (x > max) max = x
    }
    println("Max: " + max)

    import Array._
    val myMatrix = ofDim[Int](3,3)

    for (i <- 0 to 2) {
      for (j <- 0 to 2) {
        myMatrix(i)(j) = i*j
      }
    }

    for (i <- 0 to 2) {
      for (j <- 0 to 2) {
        print(" " + myMatrix(i)(j))
      }
      println()
    }


    val myList2 = Array(5.5, 6.7)

    // Concatenate two arrays
    val myList3 = concat(myList, myList2)
    val myList4 = myList ++ myList2

    println(myList3.mkString(","))
    println(myList4.mkString(","))


    val a = ArrayBuffer(1,2,3)

    a ++= ArrayBuffer(4,5,6)

    a += (7,8,9)

    println(a.mkString(","))

    // a.apply(3) same as a(3)
    val b = a.apply(3)
    println(b)

    val c = Array.apply("a", "b","c")
    println(c.mkString(","))

    // Slice to get a part of an array
    // Starts at element a(3) and stops at a(4)
    println(a.slice(3,5).mkString(","))

  }
}
