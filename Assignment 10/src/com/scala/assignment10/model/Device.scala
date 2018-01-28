package com.scala.assignment10.model

import scala.concurrent.Future

case class Device(id: Int, var name: String, var location: String) {
}

object Device {
  val locationMap = Map(1 -> "1", 2 -> "1", 3 -> "2", 4 -> "1")

  def findAll:Future[Option[List[Device]]] = ???

  def findLocationForDevice(deviceId: Int)= {
    locationMap(deviceId)
  }
}

