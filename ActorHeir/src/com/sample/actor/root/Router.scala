package com.sample.actor.root

import akka.actor.Actor
import akka.actor.ActorSystem
import com.sample.actor.model.OrderItem
import akka.util.Timeout
import scala.concurrent.duration.FiniteDuration
import java.util.concurrent.TimeUnit
import scala.util._
import scala.concurrent.ExecutionContext.Implicits._
import com.sample.actor.workers.StateActor
import akka.actor.Props
import akka.actor.OneForOneStrategy
import akka.actor.SupervisorStrategy._
import com.sample.actor.model.State
import com.sample.actor.model.City
import com.sample.actor.workers.CityActor
import com.sample.actor.model.StateSwitcher


class Router extends Actor{
  implicit val timeout = Timeout(FiniteDuration(1, TimeUnit.SECONDS))
  override def preStart() = println("The Supervisor is ready to supervise")
  override def postStop() = println("Bye Bye from the Supervisor")
 
  override def supervisorStrategy = OneForOneStrategy() {
    case _: Exception => Restart
  } 

  def receive = {
    case msg:OrderItem => {
      context.actorSelection(msg.state).resolveOne().onComplete { 
        case Success(actorRef) => actorRef ! msg
        case Failure(ex)=> ex
      }
    }
    case state:State=>{
          println(s"Creating actor for state ${state.state}")
          context.actorOf(Props[StateActor],state.state)
    }
    case city:City=>{
      context.actorSelection(city.state).resolveOne().onComplete { 
        case Success(actorRef) => actorRef ! city
        case Failure(ex)=> ex
      }
    }
    case switch:StateSwitcher=> {
      println(s"Switching state for ${switch.state}")
      context.actorSelection(switch.state).resolveOne().onComplete { 
        case Success(actorRef) => actorRef ! switch
        case Failure(ex)=> ex
      }
    }

    case _ =>{
      println("Could not understand that")
    }
  }
}