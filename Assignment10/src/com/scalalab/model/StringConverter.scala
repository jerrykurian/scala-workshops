package com.scalalab.model

import scala.util.matching.Regex

trait StringConverter {
  implicit def extractEventData(data: String):Event ={
    val pattern = new Regex(raw"([0-9]+)(\s\w+\W+)([0-9]+)")
    val pattern(eventId, eventDescription, deviceId) = data
    new Event(eventId.toInt,deviceId.toInt,eventDescription)
  }
}
