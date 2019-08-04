package com.jmsilla.scala

import scala.concurrent.{ExecutionContext, Future}
import ExecutionContext.Implicits.global
import scala.reflect.ClassTag

final class Sandwich(val ingredients: Seq[Ingredient])

object Sandwich {
  def apply(allIngredients: Seq[Option[Ingredient]]): Sandwich = {
    println(allIngredients)
    val availableIngredients = allIngredients.flatten

    new Sandwich(availableIngredients)
  }
}

sealed trait Ingredient
case class Ham() extends Ingredient
case class Cheese() extends Ingredient
case class Lettuce() extends Ingredient
case class Maionnaise() extends Ingredient

final class SandwichMaker {
  def hamFuture(): Future[Option[Ingredient]] = {
    println("Ham"); Future.successful(Option(Ham()))
  }
  
  def cheeseFuture(): Future[Option[Ingredient]] = {
    println("Cheese"); Future.successful(Option(Cheese()))
  }
  
  def lettuceFuture(): Future[Option[Ingredient]] = {
    println("Lettuce"); Future.successful(Option(Lettuce()))
  }
  
  def maionnaiseFuture(): Future[Option[Ingredient]] = {
    println("Maionnaise"); Future.successful(Option(Maionnaise()))
  }
  
  def makeSandwich(): Future[Sandwich] = {
    for {
    	maionnaiseOption <- maionnaiseFuture()
      hamOption <- hamFuture()
      lettuceOption <- lettuceFuture()
      cheeseOption <- cheeseFuture()
    } yield Sandwich(Seq(hamOption,cheeseOption,lettuceOption,maionnaiseOption))
  }
}

object SandwichMaker extends App{
  val maker = new SandwichMaker
  maker.makeSandwich
}