package com.learning

/**
  * Created by davi5017 on 3/8/2016.
  */
object Matching {
  def main(args: Array[String]): Unit = {
    println(matchTest("two"))
    println(matchTest(2))
    println(matchTest(1))

  }

  def matchTest(x: Any): Any = x match {
    case 1 => "one"
    case "two" => 2
    case y: Int => "David.Int" + y
    case _ => "many" }

}


