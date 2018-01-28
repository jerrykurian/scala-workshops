package com.scala.actor
import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
object System extends App {
  val sampleActorSystem = ActorSystem("SampleActorSystem")
  val sampleActor = sampleActorSystem.actorOf(Props[ActorSample],
    "MySampleActor")
  implicit val timout = Timeout(100 seconds)
  val res = sampleActor ? "Hello World"
  res.onComplete {
    case Success(msg) => println(s"Got $msg")
    case Failure(ex) => ex.printStackTrace()
  }
}
