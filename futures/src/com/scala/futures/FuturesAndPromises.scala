package com.scala.futures

import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

object FuturesAndPromises extends App{
  val p = Promise[String]
  val f = p.future
  Producer.produce(p)
  Consumer.consume(f)
  while(true){}
}
