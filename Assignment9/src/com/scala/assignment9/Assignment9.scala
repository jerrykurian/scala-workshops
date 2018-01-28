package com.scala.assignment9

import com.scala.assignment9.model.User
import com.scala.assignment9.printer.PrinterWriter

object Assignment9 extends App {
  writeOutputs()
  def writeOutputs(){
    val printerWriter = GenericObjectWriter.
      writeOutToWriter[User](new PrinterWriter())(_)
    val printerUserWriter =
      printerWriter(obj=>s"${obj.firstName} ${obj.lastName}")(_)

    printerUserWriter(User("Scala", "Coder"))
    printerUserWriter(User("Scala", "Coder1"))
  }
}
