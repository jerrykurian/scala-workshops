package com.scala.actors.sender
import akka.actor.ActorRef
import com.scala.actors.model.{Event, StringConverter}
class EventSender(receiver:ActorRef) extends StringConverter{
  def sendEvents: Unit ={
    var inputMessage = "Start"
    while(true){
      inputMessage = scala.io.StdIn.readLine("Event> ")
      println(s"Got ${inputMessage}")
      inputMessage match{
        case "Stop" => return
        case a:String => {
          try{
            val event: Event = a
            receiver ! event
          }catch {
            case e:Exception => println("Could not understand that message")
          }
        }
        case _ =>
      }
    }
  }
}
