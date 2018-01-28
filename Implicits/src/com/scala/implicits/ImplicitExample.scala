package com.scala.implicits

object ImplicitExample extends App with StringConverter {
  implicit val value = 10

  mul(10)
  printer(20)
  def mul(a:Int)(implicit b:Int): Unit ={
    println(a*b)
  }

  def printer(msg:String): Unit ={
    print(msg)
  }
}
