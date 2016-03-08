package com.learning

/**
  * Created by davi5017 on 3/4/2016.
  */
object JsonTest extends App {
//https://github.com/json4s/json4s
  import org.json4s._
  import org.json4s.native.JsonMethods._
  import org.json4s.JsonDSL._

  val a = parse(""" { "name": "david", "numbers" : [1, 2, 3, 4] } """)

  println(a.getClass().getName())




  val json = List(1,2,3)
  val line = compact(render(json))
  println(line)

  val json2 = ("name" -> "david") ~ ("list" -> json)

  val line2 = pretty(render(json2))
  println(line2)


}
