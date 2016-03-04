package com.learning

/**
  * Created by davi5017 on 3/1/2016.
  */
class Rational(n: Int, d: Int) {
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  println(g)
  val numer = n / g
  val denom = d / g
  def this(n: Int) = this(n,1) // auxillary constructor
  override def toString =  numer + "/" + denom

  def + (i: Int): Rational = new Rational(
    numer + i * denom, denom
  )
  def + (that: Rational): Rational = new Rational(
    numer * that.denom + that.numer * denom,
    denom * that.denom
  )
  def * (i: Int): Rational = new Rational(
    numer * i,denom
  )
  def * (that: Rational): Rational = new Rational(
    numer * that.numer,
    denom * that.denom
  )
  def lessThan(that: Rational) =
    numer * that.denom < that.numer * denom
  def max(that: Rational) =
    if (this.lessThan(that)) that else this
  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

object Rational extends App {
  //println("OK")
  val a = new Rational(1,2)
  println(a)

  val b = new Rational(2,3)
  println(b)

  val c = a + b
  println(c)
  println(c.numer)

  println(a.lessThan(b))

  println(a.max(b))

  val d = new Rational(66, 42)
  println(d)

  println(d + 2)
  println(d * 2)

}
