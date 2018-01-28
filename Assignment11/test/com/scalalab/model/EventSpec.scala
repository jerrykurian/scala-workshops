package com.scalalab.model

import org.scalatest.{FlatSpec, Matchers}
import scala.concurrent.ExecutionContext.Implicits._
import scala.util.{Failure, Success}

class EventSpec extends FlatSpec with Matchers{

  "The event list " should " return first event" in {
    Event.findAllEvents() match {
      case Some(e) => e.head shouldNot be (null)
      case None => fail()
    }
  }
  "The event list size" should " increase by 1" in {
    Event.addEvent(Event(1,1,"New Event")).onComplete {
      case Success(e) => {
        Event.findAllEvents() match {
          case Some(e) => e.size should be(5)
          case None => fail()
        }
      }
      case Failure(ex) => fail()
    }
  }

  "The update of event with id 0" should "throw exception" in {
    try{
      Event.updateEvent(Event(0,1,"None Event"))
      fail("No exception thrown")
    }catch{
      case ex:EventNotAvailableException => assert(true)
      case e:Exception => fail("Unexpected Exception")
    }
  }
  "The update of event with id 1" should "not throw exception" in {
    try{
      Event.updateEvent(Event(1,1,"None Event"))
    }catch{
      case ex:EventNotAvailableException => fail(ex.getMessage)
      case e:Exception => fail("Unexpected Exception")
    }
  }
}
