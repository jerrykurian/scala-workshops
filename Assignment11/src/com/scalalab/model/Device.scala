package com.scalalab.model

case class Device(id: Int, var name: String, var location: String) {
}
object Device {
  val devices = List(Device(1,"Device 1","Loc 1"), Device(2,"Device 2", "1"),
    Device(3, "Device 3", "2"), Device(4, "Device 4", "1"))
  val locationMap = Map(1 -> "1", 2 -> "1", 3 -> "2", 4 -> "1")

  def findAllDevices(): Option[List[Device]] = {
    if(devices.isEmpty){
      None
    }else{
      Some(devices)
    }
  }
  def mapDeviceToLocation(deviceId: Int)= {
    locationMap(deviceId)
  }

  def update(device: Device)(col: String, value: String){
    col match {
      case "devicename" => device.name = value
      case "locationname" => device.location = value
    }
  }
}
