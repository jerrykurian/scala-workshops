package com.scala.futures
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}

object Producer {
  def produce(p:Promise[String]) = Future {
    println("Producing")
    try{
      val r = produceSomething()
      p success r
    }catch {
      case e=> p failure e
    }
  }
  def produceSomething(): String ={
    scala.io.StdIn.readLine("Event> ")
  }
}
