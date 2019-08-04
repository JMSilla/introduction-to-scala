package com.jmsilla.scala

object ValuesVariablesFunctions extends App {
  val str1 = "Hello"
  // Can't reassign val elements (next line doesn't compile) 
  // str1 = "Goodbye"
  
  var str2 = "Hello"
  str2 = "Hi"
  println(str2)
  
  println("Before sleep")
  val block = {Thread.sleep(5000); "Hi" }
  println("After sleep")
  
  println("Before lazy val sleep")
  lazy val blockLazy = {Thread.sleep(5000); "Hi" }
  println("After lazy val sleep")
  
  println("Before lazy val evaluation")
  println(blockLazy)
  println("After lazy val evaluation")
  
  println("Before def declaration")
  def defLazy = {Thread.sleep(5000); "Hi" }
  println("After def declaration")
  
  val immutableSet = Set(1, 2, 3)
  val newSet = immutableSet + 4
  println(immutableSet)
  println(newSet)
}