package com.scala.assignment2.worker

trait MessageWorker {
  def sendMessage(message:String)={
    println(message)
  }
}
