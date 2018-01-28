package com.scala.assignment2.model

class Person(val firstName:String,
                     val lastName:String,
                     ) {
  private var address: Address = null
  def this(firstName:String,
    lastName: String, address:Address){
    this(firstName,lastName)
    this.address = address
  }
  def addressVal(address:Address): Unit ={
    this.address = address
  }
}
object Person{
  def findAllPeople:List[Person] = {
    val p = new Person("FN", "LN")
    p.addressVal(new Address("D"))
    List(new Person("FN","LN",
      ))
  }
  def create(firstName: String, lastName:String): Unit ={
    val person = new Person(firstName,lastName,
      new Address("d"))
  }
}
