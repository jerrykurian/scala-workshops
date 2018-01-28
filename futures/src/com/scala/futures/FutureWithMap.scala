package com.scala.futures

import scala.concurrent.Future
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global
object FutureWithMap extends App{
  val intVal = getSomeString()
  intVal onComplete {
    case Success(x) => println(x)
    case Failure(e) => e.printStackTrace()
  }

  def getSomeString():Future[String] = {
    getFromDb map (
     x => x.toString
    )
  }
  def getFromDb:Future[Int] = Future {
    10
  }
}
