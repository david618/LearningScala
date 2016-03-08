package com.learning

/**
  *
  *
  * http://www.codecommit.com/blog/scala/case-classes-are-cool
  * If you use modifier case in class definition you automatically get
  * -> constructor parameters become public fields
  * -> methods toString, equals, and hashCode are defined based on constructor fields
  * -> companion object containing apply() constructor and extractor based on constructor fields
  *
  */
case class PersonCase(firstName: String, lastName: String)

case class Animal(name: String)

