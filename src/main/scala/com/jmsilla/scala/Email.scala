package com.jmsilla.scala

case class Email (local: String, domain: String)

object Email extends App {
  def apply(email: String): Email = {
     val emailParts = email.split("@")
     
     if (emailParts.length >= 2) { 
       Email(emailParts(0), emailParts(1))
     }
     else {
       Email(emailParts(0), "")
     }
  }
  
  println(Email(""))
  println(Email("hello"))
  println(Email("test@test.com"))
  println(Email("test@test@test.com"))
}