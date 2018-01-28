package com.scala.actor

import akka.actor.Actor

class ActorSample extends Actor{
  override def receive: Receive = {
    case msg => {
      println(s"Got the message ${msg}")
      sender ! "Hello to you too"
    }
  }
}
