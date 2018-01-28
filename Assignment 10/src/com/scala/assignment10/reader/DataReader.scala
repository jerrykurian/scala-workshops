package com.scala.assignment10.reader

import scala.concurrent.Future

trait DataReader[T] {
  def readFromSource():Future[Option[List[T]]]
}
