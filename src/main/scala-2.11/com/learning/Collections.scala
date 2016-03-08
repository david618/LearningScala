package com.learning

/**
  * Created by davi5017 on 3/8/2016.
  */
object Collections {

  def lists(): Unit = {

    val xList = List(1,2,3,4)
    println(xList.mkString(","))

    // List of Strings
    val fruit: List[String] = List("apples", "oranges", "pears")

    // List of Integers
    val nums: List[Int] = List(1,2,3,4)

    //Empty List
    val empty: List[Nothing] = List()

    // 2D Lists
    val dim: List[List[Int]] =
      List(
        List(1,0,0),
        List(0,1,0),
        List(0,0,1)
      )

    println("Head of fruit: " + fruit.head)
    println("Tail of fruit: " + fruit.tail)

    val fruit2 = "apples" :: ("banana" :: Nil)

    // Make a new list concatenating
    val fruit3 = fruit ::: fruit2
    println(fruit3.mkString(","))

    // Concat to lists and convert to set
    val fruitSet = fruit.:::(fruit2).toSet
    println(fruitSet.mkString(","))

    println(fruit3.sorted.mkString(","))
    println(fruit3.sortWith(_.length > _.length).mkString(","))

    // Fill and Tabulate
    // Fill inserts the same element multiple time
    val squares = List.tabulate(6)(n => n* n)
    println(squares.mkString(","))

    val mul = List.tabulate(4,5)(_ * _)
    println(mul)

    val xMap = xList.map((x) => {
      x*x
    })
    println(xMap.mkString(","))

    println(fruit.max)

  }

  def sets(): Unit = {
    var A: Map[Char, Int] = Map()

    A += ('I' -> 1)
    A += ('J' -> 5)
    A += ('K' -> 10)
    A += ('L' -> 100)
    val colors = Map("red" -> "#FF0000",
      "azure" -> "#F0FFFF",
      "peru" -> "#CD853F")

    val nums: Map[Int, Int] = Map()

    println( "Keys in colors : " + colors.keys )
    println( "Values in colors : " + colors.values )
    println( "Check if colors is empty : " + colors.isEmpty )
    println( "Check if nums is empty : " + nums.isEmpty )


    for (color <- colors ) {
      println(color._1)
      println(color._2)
    }

    val colors1 = Map("red" -> "#FF0000",
      "azure" -> "#F0FFFF",
      "peru" -> "#CD853F")
    val colors2 = Map("blue" -> "#0033FF",
      "yellow" -> "#FFFF00",
      "red" -> "#FF0000")

    // use two or more Maps with ++ as operator
    var colorsCat = colors1 ++ colors2
    println( "colors1 ++ colors2 : " + colorsCat )

    // use two maps with ++ as method
    colorsCat = colors1.++(colors2)
    println( "colors1.++(colors2)) : " + colorsCat )

  }


  def main(args: Array[String]): Unit = {

    var xSet = Set(1,2,3,4)

    var xMap = Map("one" -> 1, "two" -> 2, "three" -> 3, "four" -> 4)


    var xTuple = (10, "Scala")

    var xOpt:Option[Int] = Some(5)

    //lists
    sets

  }
}
