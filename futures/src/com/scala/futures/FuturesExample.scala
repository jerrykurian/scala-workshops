package com.scala.futures

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
object FuturesExample extends App {
  def sum(a: Int, b: Int) = Future {
    if(a<b){
      Some(a + b)
    }else{
      throw new Exception()
    }
  }
  val fallBackFuture = Future{Some(0)}
  /*val sumResult = sum(7,6) recover {
    case ex:Exception => Some(0)
  }*/
  //val sumResult = sum(7,6) fallbackTo fallBackFuture
  val sumResult = sum(5,6) andThen {
    case Success(value)=>println(s"Printed ${value}")
  }
  sumResult onComplete {
    case Success(value) => value match {
      case Some(v) => println(v)
    }
    case Failure(ex) => ex.printStackTrace()
  }
  while(true){}
}
