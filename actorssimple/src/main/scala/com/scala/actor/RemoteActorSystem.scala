package com.scala.actor

import akka.actor.ActorSystem

object RemoteActorSystem extends App {
  val pingPongSystem = ActorSystem("PingPongSystem")
  val pingActorSelection = pingPongSystem.
    actorSelection("akka.tcp://pingPongSystem@localhost:2552/pingActor")
  pingActorSelection ! "Start"
}
