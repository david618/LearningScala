package com.learning

/**
  * Created by david on 1/29/2016.
  *
  * This Example is from Programming in Scala, 2nd Edition
  */
class ChecksumAccumulator {
  private var sum = 0

  def add(b: Byte): Unit = {
    sum += b
  }

  def checksum(): Int = {
    ~(sum & 0xFF) + 1
  }
}

import scala.collection.mutable

// Singleton Object
object ChecksumAccumulator {
  private val cache = mutable.Map[String, Int]()
  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
}