package com.scala.assignment10.model

import com.scala.assignment10.reader.hardcoded.HardCodedEventDataReader
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
case class Event(id: Int, description: String, deviceId: Int) {
}
object Event{
  val dataReader = HardCodedEventDataReader
  def findAll:Future[Option[List[Event]]] = {
    dataReader.readFromSource()
  }
  def findById(id:Int):Option[Event] = {
    None
  }
  def findAllFromLocation(locId: String):Future[Option[List[Event]]]={
    // Find all events
    findAll map {
      case Some(events) => {
        Some(
          events.map( // Convert into a map that holds (event, locationId)
            event=>(event, Device.findLocationForDevice(event.deviceId))
          ).filter( // Filter out the tuples at desired location
            eventWithLocation => eventWithLocation._2.equals(locId)
          ).map{ // Return a list of events from the tuple
            case (e,loc) => e
          }
        )
      }
      case None => None
    }
  }

}