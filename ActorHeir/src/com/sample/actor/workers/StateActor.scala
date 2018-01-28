package com.sample.actor.workers

import akka.actor.Actor
import com.sample.actor.model.OrderItem
import com.sample.actor.model.City
import akka.actor.Props
import scala.concurrent.ExecutionContext.Implicits._
import akka.util.Timeout
import scala.concurrent.duration.FiniteDuration
import java.util.concurrent.TimeUnit
import scala.util.Failure
import scala.util.Success
import com.sample.actor.model.StateSwitcher

class StateActor extends Actor{
  implicit val timeout = Timeout(FiniteDuration(1, TimeUnit.SECONDS))

  def receive = router
  
  def router: Receive = {
    case oi:OrderItem => {
      //println(s"Looking up actor for city ${oi.city}")
      context.actorSelection(oi.city).resolveOne().onComplete { 
        case Success(actorRef) => actorRef ! oi
        case Failure(ex)=> ex
      }
    }
    case city:City =>{
       //println(s"Creating actor for city ${city.city}")
       context.actorOf(Props[CityActor],city.city)
    }
    case s:StateSwitcher=> {
      println("Switching to localActor")
      context.become(localActor)
    }
  }

  def localActor:Receive = {
    case oi:OrderItem => {
      println(s"Handled message in state ${oi.state}")
    }
    case s:StateSwitcher=> context.become(router)
  }

}