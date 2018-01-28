package com.scala.assignment9.printer

import com.scala.assignment9.OutputWriter

class PrinterWriter extends OutputWriter{
  override def write(message: String): Unit = {
    println(s"Printing to the printer ${message}")
  }
}
