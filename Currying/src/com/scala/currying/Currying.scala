package com.scala.currying
object Currying {
  def main(args: Array[String]): Unit = {
    val f6 = cub(5)(_) // Returns a function of type Int=>(Int=>Int)
    val f7 = findBAndApply(f6) // Returns a function of type Int=>Int
    println(findCAndApply(f7))
  }
  def findBAndApply(f:(Int)=>(Int=>Int)): Int=>Int ={
    f(5)(_)
  }
  def findCAndApply(f:(Int)=>Int): Int ={
    f(4)
  }
  def cub(a:Int)(b:Int)(c:Int)=a*b*c
}
