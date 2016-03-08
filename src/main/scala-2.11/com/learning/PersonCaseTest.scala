package com.learning

/**
  * Created by davi5017 on 3/7/2016.
  */
object PersonCaseTest extends App {
  val me = PersonCase("David", "Jennings")
  val first = me.firstName
  val last = me.lastName

  if (me == PersonCase(first,last)) {
    println("Found myself!")
    println(me)
  }

  val pet = Animal("Spunky")
  println(pet.name)
}
