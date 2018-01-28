package com.scala.assignment10

import com.scala.assignment10.Main.events
import com.scala.assignment10.model.Event

import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global
object Main extends App {
  val events = Event.findAllFromLocation("2")
  events onComplete {
    case Success(events) => events match {
        case Some(event) => event.foreach(println(_))
        case None => println("None Found")
      }
    case Failure(ex) => println("Could not get the events")
  }
  while (true)()
}