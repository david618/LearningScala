package com.learning

import java.io.{FileInputStream, ObjectInputStream, FileOutputStream, ObjectOutputStream}

/**
  * Created by davi5017 on 3/4/2016.
  */
class Person(val age: Int) extends Serializable {
  override def toString = s"Person($age)"


}




object Person extends App {


  def mMatch(s: String) = {
    // The backticks are to make a stable identifier form lowercase variable
    // Uppercase or backticks comes from from surrounding scope
    val target: String = "a"
    s match {
      case `target` => "It was " + target
      case _ => "It was something else"
    }
  }

  def mMatch2(s: String) = {
    // Preferred is val's atart with uppercase
    val Target: String = "a"
    s match {
      case Target => println("It was " + Target)
      case _ => println("It was something else")
    }
  }

  def test1() = {
    val a = new Person(22)
    System.out.println(a)

    val fn = "C:\\Temp2\\Person.dat"

    val os = new ObjectOutputStream(new FileOutputStream(fn))
    os.writeObject(a)
    os.close()

    val is = new ObjectInputStream(new FileInputStream(fn))
    val b = is.readObject()
    is.close()

    System.out.println(b)
  }



  val a = mMatch("b")
  System.out.println(a)
}