package com.scala.actor.pingpong

import akka.actor.Actor
import com.scala.actor.model.{PingMessage, PongMessage}

class PongActor extends Actor{
  override def receive: Receive = {
    case PongMessage(msg) => {
      print(msg)
      sender ! PingMessage("Pong")
    }
    case "Stop" => context.stop(self)
  }
}
