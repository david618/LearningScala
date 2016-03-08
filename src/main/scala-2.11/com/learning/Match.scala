package com.learning

/**
  * Created by davi5017 on 3/7/2016.
  */
object Match extends App {
  def fMatch(s: String): String = {
    s match {
      case "a" => "It was a"
      case _ => "It was something else"
    }

  }


  def mMatch(s: String): String = {
    // This code Fails always returning "It is a"
    val target: String = "a"
    s match {
      case target => "It was a"
      case _ => "It was something else"
    }

  }

  def nMatch(s: String): String = {
    // This code works because the backticks force local scope resolution using literal identifier
    val target: String = "a"
    s match {
      case `target` => "It was a"
      case _ => "It was something else"
    }

  }


  def kMatch(s: String): String = {
    // This code work because Target starts with capital
    val Target: String = "a"
    s match {
      case Target => "It was a"
      case _ => "It was something else"
    }

  }


  println(mMatch("a"))
  println(mMatch("b"))
  println(nMatch("a"))
  println(nMatch("b"))
  println(kMatch("a"))
  println(kMatch("b"))
}
