package com.scala.actors

import akka.actor.ActorSystem
import com.scala.actors.receiver.MessageReceiver
import com.scala.actors.sender.EventSender

object MessagingSystem extends App {
  start

  def start: Unit ={
    val actorSystem = ActorSystem("EventManagers")
    val receiverActor = actorSystem.actorOf(MessageReceiver.props,"MessageReceiver")
    val eventSender = new EventSender(receiverActor)
    eventSender.sendEvents
  }
}
