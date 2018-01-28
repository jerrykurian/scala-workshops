package com.scalalab.model

import scala.collection.mutable.ListBuffer
import scala.util.matching.Regex

case class Event(id: Int, deviceId: Int, description: String) {
}
object Event extends StringConverter{
  val events = ListBuffer(Event(1, 1, "event 1"), Event(2, 1, "event 2"),
    Event(3, 3, "event 3"),
    Event(4, 1, "event 4"))
  def findAllEvents(): Option[List[Event]]={
    if(events.isEmpty){
      None
    }else{
      Some(events.toList)
    }
  }

  def addEvent(event: Event): Event = {
    events.insert(0,event)
    println(s"Returning $event")
    event
  }

  @throws(classOf[EventNotAvailableException])
  def updateEvent(event: Event): Event = {
    if(event.id == 0){
      throw new EventNotAvailableException()
    }
    events.insert(0,event)
    event
  }

  def findAllEventsForALocation(location: String) = {
    // Find all events
    findAllEvents() match {
      case Some(events) => {
        Some(events.map(
          event=>(event, Device.mapDeviceToLocation(event.deviceId))
        ).filter(
          eventWithLocation => eventWithLocation._2.equals(location)
        ))
      }
      case None => None
    }
  }
    // Summarize like Event ID <id1> Device ID <id1> <description1> Event ID <id2> Device ID <id2> <description2>
  def findEventDescriptionSummary():String ={
    events.foldLeft(""){(left, right)=>
      left + returnEventAsString(right)
    }
  }
  def returnEventAsString(event:Event):String = {
    s"Event ID ${event.id} Device ID ${event.deviceId} ${event.description}\n "
  }
}