package com.scala.assignment10.reader.hardcoded

import com.scala.assignment10.model.Event
import com.scala.assignment10.reader.DataReader
import com.scala.assignment10.model.StringConverter.extractEventData

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
object HardCodedEventDataReader extends DataReader[Event] {
  def readFromSource():Future[Option[List[Event]]]= Future {
    // Could be Some(List())
    Some(
      List("1 ABC 1","2 AAA 3","2 AAC 1")
    )
  }
}
