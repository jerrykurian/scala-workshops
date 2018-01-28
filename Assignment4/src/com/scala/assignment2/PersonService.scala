package com.scala.assignment2
import com.scala.assignment2.model.Person
import com.scala.assignment2.worker.email.EmailMessageWorker

object PersonService {
  def findAllPeople = {
    Person.findAllPeople
  }

  def createPerson(firstName:String, lastName:String): Unit ={
    Person.create(firstName,lastName)
    EmailMessageWorker.sendMessage("Registered")
  }
}
