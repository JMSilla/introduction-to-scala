package com.jmsilla.scala

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext

object Futures extends App {
  def simulate(message: String, duration: Duration) = {
    println("Start: " + message)
    Thread.sleep(duration.toMillis)
    println("End: " + message)
  }
  
  def task30Seconds() = simulate("30 seconds task", 30 seconds) 
  def task10Seconds() = simulate("10 seconds task", 10 seconds)
  def task30SecondsAsync(): Future[Unit] = Future(task30Seconds())
  def task10SecondsAsync(): Future[Unit] = Future(task10Seconds())
  
  println("Sync calls")
  
  task30Seconds()
  task10Seconds()
  
  println("After sync calls")
  
  println("Async calls")
  
  val task30Future = task30SecondsAsync()
  val task10Future = task10SecondsAsync()
  
  Await.result(task30Future, 5 minutes)
  Await.result(task10Future, 5 minutes)
  
  println("After async calls")
  
  def benchmark[T](name: String, task: => T): T = {
    println(s"Task $name starts")
    val result = task
    println(s"Task $name ends")
    result
  }
  
  println("For")
  
  def number1: Future[Option[Int]] = benchmark("number1", Future.successful(Option(1)))
  def number2: Future[Option[Int]] = benchmark("number2", Future.successful(Option(2)))
  def number1Delay: Future[Option[Int]] = benchmark("number1Delayed", {
    Thread.sleep(5.seconds.toMillis)
    Future.successful(Option(1))
  })
  
  val result = for {
    first <- number1
    second <- number2
  } yield Seq(first, second)
  
  Await.result(result, 10 seconds)
  
  println("End for: " + result)
  
  println("For delayed")
  
  val resultDelayed = for {
    first <- number1Delay
    second <- number2
  } yield Seq(first, second)
  
  Await.result(resultDelayed, 10 seconds)
  
  println("End for delayed: " + resultDelayed)  
}