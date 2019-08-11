package com.jmsilla.scala


object HighOrderFunctions extends App{
	def logger(appName:String)(logMessage:String):Unit = {
			println(s"$appName - $logMessage")
	}
  
  val appLogger = logger("AppName")(_)
  
  appLogger("Log message")
  appLogger("Log message 2")
}