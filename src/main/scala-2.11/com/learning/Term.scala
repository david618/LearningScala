package com.learning

/**
  * Created by davi5017 on 3/7/2016.
  */
abstract class Term {


}

object Term {

  case class Var(name: String) extends Term

  case class Fun(arg: String, body: Term) extends Term

  case class App(f: Term, v: Term) extends Term

}

