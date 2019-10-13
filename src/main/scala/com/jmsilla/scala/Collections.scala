package com.jmsilla.scala

object WordCounter {
  def countWords(text: String): Int = {
    text match {
      case null => 0
      case "" => 0
      case _ => text.split("\\s").length
    }
  }
}

object WordAggregator {
  def aggregateWords(text: String): Map[String, Int] = {
    text match {
      case null => Map.empty
      case "" => Map.empty
      case _ => text.split("\\s").groupBy(identity).mapValues(a => a.length);
    }
  }
}

object Collections extends App {
  println(WordCounter.countWords(""));
  println(WordCounter.countWords("Hello"));
  println(WordCounter.countWords("Hello and goodbye"));
  
  println(WordAggregator.aggregateWords(""));
  println(WordAggregator.aggregateWords("Hello"));
  println(WordAggregator.aggregateWords("Hello hola hi hola Hello hello goodbye"));
}