package com.scala.assignment1

object Assignment1 {

  def main(args:Array[String]): Unit ={
    val list1 = List(1,4,6,7)
    val list2 = List(6,5,7,6)
    val result = listOperator(list1, list2, 1)
    println(s"Result is ${result}")
    if(result>100){
      printList(list1 ::: list2)
    }else{
      printList(list2 ::: list1)
    }
  }

  def listOperator(list1:List[Int], list2:List[Int],
                   switch:Int)={
    if(switch==0){
      var result = 0
      for(x <- list1){
        result = result + x
      }
      result
    }else{
      var result = 1
      for(x <- list1){
        result = result * x
      }
      result
    }
  }

  def printList(list: List[Int]): Unit ={
    for(i <- list){
      print(i + ",")
    }
  }
}
