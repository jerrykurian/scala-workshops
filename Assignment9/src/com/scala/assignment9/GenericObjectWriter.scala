package com.scala.assignment9

object GenericObjectWriter {
  def writeOutToWriter[A](outputWriter: OutputWriter)
                         (f:A=>String)(in: A): Unit ={
    outputWriter.write(f(in))
  }
}
