package com.scala.implicits

trait StringConverter {
  implicit def convert(value:Int)=value.toString
}
