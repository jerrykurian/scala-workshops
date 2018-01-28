package com.scalalab.starter

import com.scalalab.model.{Device, Event}

object Starter {
  def main(args: Array[String]): Unit ={
    val event = Event.addEvent("1 ad 1")
    println(s"Inserted event $event")
    println("I carried on")
    Thread.sleep(10000)
  }

  def printEventsAt(location: String): Unit = {
    println(s"Printing at $location" )
    Event.findAllEventsForALocation(location) match {
      case Some(e) => e.foreach(e => println(e))
      case None => print("Nothing Found")
    }
  }
}
