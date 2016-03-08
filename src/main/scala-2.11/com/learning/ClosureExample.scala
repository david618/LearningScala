package com.learning

import scala.collection.mutable.ArrayBuffer

/**
  * Closure is a block of code which meets three criteria (1) passed as value (2) can be execute on demand by anyone who as that value
  * (3) can refer to variables from the context in which it was created
  */

class Foo {
  def exec(f:String => Unit, name: String): Unit = {
    f(name)
  }
  def buyStuff(f: String => Unit, s: String): Unit = {
    f(s)
  }
}

object ClosureExample extends App {
  var hello = "Hello"
  def sayHello(name: String) { println(s"$hello, $name")}

  val foo = new Foo
  foo.exec(sayHello, "Al")

  hello = "Hola"
  foo.exec(sayHello, "Al")

  var votingAge = 18
  val isOfVotingAge = (age: Int) => age >= votingAge

  println(isOfVotingAge(16))
  println(isOfVotingAge(20))

  votingAge = 30

  println(isOfVotingAge(16))
  println(isOfVotingAge(20))

  val fruits = ArrayBuffer("apple")

  val addToBasket = (s:String) => {
    fruits += s
    println(fruits.mkString(", "))
  }

  foo.buyStuff(addToBasket, "cherries")
  foo.buyStuff(addToBasket, "grapes")


}
