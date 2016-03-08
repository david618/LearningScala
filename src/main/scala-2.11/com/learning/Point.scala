package com.learning

/**
  * Created by davi5017 on 3/7/2016.
  */

trait Equal {
  def isEqual(x: Any): Boolean
  def isNotEqual(x: Any): Boolean = !isEqual(x)
}

case class Point(x: Int, y: Int) extends Equal {
//  var x: Int = xc
//  var y: Int = yc
  def move(dx: Int, dy: Int): Point = {
    Point(x + dx, y + dy)
  }
  override def toString(): String = "(" + x + "," + y + ")"

  override def isEqual(x: Any): Boolean = {
//    println(x.isInstanceOf[Point])
//    println(x.asInstanceOf[Point])
//    println(this)
//    x.isInstanceOf[Point] && x.asInstanceOf[Point] == this
    x.equals(this)
  }
}


// You can't extend case class to case class
class Location(override val x: Int, override val y: Int,
                   val z: Int) extends Point(x,y) {

  val this.x = x
  val this.y = y
  val this.z = z

  override def toString(): String = "(" + x + "," + y + "," + z + ")"

  def move(dx: Int, dy: Int, dz: Int): Location = {
    new Location(x + dx, y + dy, z + dz)

  }
}

