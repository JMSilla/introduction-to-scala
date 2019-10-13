package com.jmsilla.scala

sealed abstract class IngeribleSealed (minCalories: Int, maxCalories: Int, 
    minCon: Int)

case object HighCalories extends IngeribleSealed (5000, 10000, 90)
case object MediumCalories extends IngeribleSealed (1000, 5000, 50)
case object LowCalories extends IngeribleSealed (0, 1000, 0)

object IngeribleEnum extends Enumeration {
  type IngeribleEnum = Value
  
  protected case class Val(minCalories: Int, maxCalories: Int, minCon: Int) 
    extends super.Val
    
  val HighCalories = Val(5000, 10000, 90)
  val MediumCalories = Val(1000, 5000, 50)
  val LowCalories = Val(0, 1000, 0)
}

object Ingerible extends App{
  val value: IngeribleSealed = HighCalories
  
  value match {
    case HighCalories => println("High")
    case MediumCalories => println("Medium")
    case LowCalories => println("Low")
  }
  
  val valueEnum = IngeribleEnum.HighCalories
  
  println(valueEnum.minCalories + "-" + valueEnum.maxCalories 
      + "-" + valueEnum.minCon)
}