package com.sample.actor

import akka.actor.ActorSystem
import akka.actor.Props
import com.sample.actor.root.Router
import com.sample.actor.model.OrderItem
import com.sample.actor.model.City
import com.sample.actor.model.State
import com.sample.actor.model.StateSwitcher

object Boot extends App{
  val system = ActorSystem("LogisticsSystem")
  val actorRef = system.actorOf(Props[Router], "root")
  
  createState
  createCity
  Thread.sleep(5000)
  sendMessages
  
  def createState{
    actorRef ! State("KA")
    actorRef ! State("TN")
  }
  def createCity{
    actorRef ! City("Bangalore", "KA")
    actorRef ! City("Chennai", "TN")
  }
  def sendMessages{
    actorRef ! OrderItem("KA", "Bangalore", "1")
    actorRef ! OrderItem("TN", "Chennai", "1")
    actorRef ! OrderItem("KA", "Bangalore", "1")
    actorRef ! OrderItem("KA", "Bangalore", "1")
    actorRef ! OrderItem("TN", "Chennai", "1")
    actorRef ! StateSwitcher("KA")
    actorRef ! OrderItem("TN", "Chennai", "1")
    actorRef ! OrderItem("TN", "Chennai", "1")
    actorRef ! OrderItem("KA", "Bangalore", "1")
    actorRef ! OrderItem("KA", "Bangalore", "1")
  }
}