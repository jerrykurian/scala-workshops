package com.scala.assignment2.worker.email

import com.scala.assignment2.worker.MessageWorker

object EmailMessageWorker extends MessageWorker{
  override def sendMessage(message: String): Unit = {
    println("Sending email")
  }
}
