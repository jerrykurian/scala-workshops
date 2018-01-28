package com.scala.assignment3

object Assignment3 {

  def main(args:Array[String]): Unit ={
    val list1 = List(1,4,6,7)
    val list2 = List()
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
      list1.sum
    }else{
      list2.foldRight(1)(
        (current, prod)=>{
          current*prod
        }
      )
    }
  }

  def printList(list: List[Int]): Unit ={
    for(i <- list){
      print(i + ",")
    }
  }
}
