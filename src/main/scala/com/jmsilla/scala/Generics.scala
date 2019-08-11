package com.jmsilla.scala

class GenericWrapper[T](var value: T) {
  def getValue = value
  def setValue(newValue: T) = {
    value = newValue
  }
}

object Generics extends App{
  val wrappedValue = new GenericWrapper[Int](8)
  
  println(wrappedValue.getValue)
  wrappedValue.setValue(5)
  println(wrappedValue.getValue)
}