package com.scala.assignment2

object Assignment2 {

  def main(args: Array[String]): Unit = {
    val cats = Map(1->"Up",2->"Up",3->"Down",
      4->"Up",5->"Up",6->"Down",
      7->"Up",8->"Down",9->"Down", 10->"Down")
    val list1 = List(1,6,8,11)
    val (up,down, none) = categorize(cats, list1)
    println(s"${up} - ${down} - ${none}")
  }
  def categorize(cats: Map[Int, String], list1: List[Int]) = {
    var upCount = 0;var downCount=0;var noneCount=0

    for(elem <- list1){
      try{
        val category = cats(elem)
        category match {
          case "Up" => upCount+=1
          case "Down" => downCount+=1
          case _ => noneCount+=1
        }
      }catch{
        case e:Exception => noneCount+=1
      }
     }
    (upCount, downCount, noneCount)
  }
}
