package com.learning

import java.util.Date

/**
  * Created by davi5017 on 3/8/2016.
  */
object JsonExample extends App {


  import org.json4s._
  import org.json4s.JsonDSL._
  import org.json4s.native.JsonMethods._

  case class Winner(id: Long, numbers: List[Int])

  case class Lotto(id: Long, winningNumbers: List[Int], winners: List[Winner], drawData: Option[java.util.Date])

  val winners = List(Winner(23, List(2, 45, 34, 23, 3, 4)), Winner(54, List(52, 3, 12, 11, 18, 22)))
  val lotto = Lotto(5, List(2, 45, 34, 23, 7, 5, 3), winners, Some(new Date()))

  val json =
    "lotto" ->
      ("lotto-id" -> lotto.id) ~
        ("winning-numbers" -> lotto.winningNumbers) ~
        ("draw-date" -> lotto.drawData.map(_.toString)) ~
        ("winners" ->
          lotto.winners.map { w =>
            ("winner.id" -> w.id) ~
              ("numbers" -> w.numbers)})

  println(pretty(render(json)))
  println(lotto.winners)
  println(lotto.winners.map(_.toString).mkString(","))


  val json2 = parse("""
               { "name": "joe",
                 "children": [
                   {
                     "name": "Mary",
                     "age": 5
                   },
                   {
                     "name": "Mazy",
                     "age": 3
                   }
                 ]
               }
    """)

  println(pretty(render(json2)))

  val x = for {
    JObject(child) <- json2
    JField("age", JInt(age)) <- child
  } yield age


  println(compact(render(json \\ "Mary")))
}
