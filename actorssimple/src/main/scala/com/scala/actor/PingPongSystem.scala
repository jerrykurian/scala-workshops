package com.scala.actor

import akka.actor.{ActorSystem, Props}
import com.scala.actor.pingpong.{PingActor, PongActor}

object PingPongSystem extends App {
  val pingPongSystem = ActorSystem("PingPongSystem")
  val pongActor = pingPongSystem.actorOf(Props[PongActor],
    "PongActor")
  val pingActor = pingPongSystem.actorOf(
      Props(new PingActor(pongActor)),
    "PingActor")
  pingActor ! "Start"
}
