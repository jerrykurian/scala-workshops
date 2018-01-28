package com.scala.actor.model

import scala.concurrent.Promise

class ResponsiveMessage {
  def onSuccess(msg:Promise[String]): Unit ={
    print("Got Success")
  }
}
