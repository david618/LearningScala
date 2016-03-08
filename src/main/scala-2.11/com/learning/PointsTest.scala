package com.learning

/**
  * Created by davi5017 on 3/7/2016.
  */
object PointsTest {
  def main(args: Array[String]): Unit = {
    var pt = Point(1,2)
    println(pt)
    pt = pt.move(10,10)
    println(pt)


    var loc = new Location(10,20,15)
    println(loc)
    loc = loc.move(1,1,1)
    println(loc)

    val p1 = new Point(2,3)
    val p2 = new Point(2,3)
    val p3 = new Point(3,3)

    println(p1.isEqual(p2))
    println(p1.isEqual(p3))


  }
}
