package com.scala.actors.receiver

import akka.actor.{Actor, ActorLogging, Props}
import com.scala.actors.model.Event

object MessageReceiver{
  //#printer-messages
  def props: Props = Props[MessageReceiver]
}

class MessageReceiver extends Actor with ActorLogging{
  override def receive = {
    case e:Event => log.info(s"${e}")
    case _ => log.info("received unknown message")
  }
}
