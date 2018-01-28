package com.scala.assignment2

object Assignment2 {

  def main(args: Array[String]): Unit = {
    val cats = Map(1->"Up",2->"Up",3->"Down",
      4->"Up",5->"Up",6->"Down",
      7->"Up",8->"Down",9->"Down", 10->"Down")
    val list1 = List(1,6,8,11)
    val result = categorize(cats, list1)
    println(s"${result}")
  }
  def categorize(cats: Map[Int, String], list1: List[Int]) = {
    //1. Group together the elements that are of the same category
    //2. Count the number of elements in each category
    //3. Return a Map with count for each category
    list1.map(l=>{ // Returns ["Up","Down","Up"]
      try{
        cats(l) // Lookup the element in the map. Will return the category
      }catch {
        // If element not found, then exception thrown. Return None
        case e:Exception => "None"
      }
    }).groupBy(k=>k).// Group by the similar elements in the list.
      // Will return a map("Up"->["Up","Up"])
      map {
        // transform to a map that return map("Up"->2)
        case (key, vals:List[String])=>(key, vals.count(v=>true))
      }
    /*
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
    (upCount, downCount, noneCount)*/
  }
}
