package com.scala.actor.pingpong

import akka.actor.{Actor, ActorRef}
import com.scala.actor.model.{PingMessage, PongMessage}

class PingActor(pongActorRef: ActorRef) extends Actor{
  val pongActor = pongActorRef
  var count = 0
  override def receive: Receive = {
    case PingMessage(a) => {
      print(a)
      if(count<100){
        sender ! PongMessage("Ping")
        count += 1
      }else{
        sender ! "Stop"
        context.stop(self)
      }
    }
    case "Start" => pongActor ! PongMessage("Ping")
  }
}
