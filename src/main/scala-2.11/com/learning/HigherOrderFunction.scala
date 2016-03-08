package com.learning

/**
  * Created by davi5017 on 3/8/2016.
  */
object HigherOrderFunction {

  def main(args: Array[String]): Unit = {
    println(apply(layout,10))

    println(layout("abc"))

    println(layout(34.56f))

    println(layout2("abc", 34.5f))
  }

  def apply(f: Int => String, v: Int) = f(v)

  def layout[T](x:T) = "[" + x.toString + "]"
  def layout2[A,B](x:A, y:B) = "[" + x.toString + "][" + y.toString + "]"
}
