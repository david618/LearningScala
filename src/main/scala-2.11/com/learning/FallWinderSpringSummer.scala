package com.learning

/**
  * Created by davi5017 on 3/1/2016.
  */

import com.learning.ChecksumAccumulator.calculate

object FallWinderSpringSummer extends App {
  for (season <- List("fall","winter","spring"))
    println(season + ":" + calculate(season))
}
