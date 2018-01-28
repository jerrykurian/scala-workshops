package com.sample.actor.workers

import akka.actor.Actor
import com.sample.actor.model.OrderItem

class CityActor extends Actor{
  
  def receive = {
    case oi:OrderItem => {
      println(s"Handled message in city ${oi.city}")
    }
  }
}