package com.learning

/**
  * Created by davi5017 on 3/8/2016.
  */
object Strings {
  def main(args: Array[String]): Unit = {
    val palindrome = "Dot saw I was Tod"
    val len = palindrome.length()
    println("String Length is " + len)

    val floatVal = 12.456
    val intVal = 2000
    val stringVal = "Hello, Scala"
    printf("The value of the float is %f \n" +
    "The value of the int is %d \nThe value of the " +
    "string is %s\n", floatVal, intVal, stringVal)


    println()
    val fmt = "The value of the float is %f \n" +
      "The value of the int is %d \n" +
      "The value of the  string is %s."
    val fs = fmt.format(floatVal, intVal, stringVal)
    println(fs)

    println()

    println(fs.charAt(0))
    println(fs.indexOf("Z"))


  }
}
