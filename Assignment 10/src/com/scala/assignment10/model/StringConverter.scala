package com.scala.assignment10.model

import scala.util.matching.Regex

object StringConverter {
  implicit def extractEventData(data: String):Event ={
    val pattern = new Regex(raw"([0-9]+)(\s\w+\W+)([0-9]+)")
    val pattern(eventId, eventDescription, deviceId) = data
    new Event(eventId.toInt,eventDescription,deviceId.toInt)
  }
}
