package com.scala.futures
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Consumer {
  def consume(f: Future[String]) = Future {
    println("Consuming")
    f onComplete  {
      case Success(msg) => println(s"Got ${msg}")
      case Failure(ex) => ex.printStackTrace()
    }
  }

}
