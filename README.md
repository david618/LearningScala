# LearningScala

This is just a simple project to capture my progress in Learning Scala 


## Scala Logging using log4j

Some sample on [github](https://github.com/apache/logging-log4j-scala). 

- cloned the repo
- Under sample folder created a build.sbt

```
name := "LoggingSample"

organization := "david"

version := "1.0.0"

scalaVersion := "2.12.7"

libraryDependencies ++= Seq(
  "org.apache.logging.log4j" %% "log4j-api-scala" % "11.0",
  "org.apache.logging.log4j" % "log4j-api" % "2.11.0",
  "org.apache.logging.log4j" % "log4j-core" % "2.11.0" % Runtime
)

```

The log4j2.xml defines the level.

Played with sample a little.

```
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */
package org.apache.logging.log4j.scala.sample

import java.util.UUID

import org.apache.logging.log4j.message.MessageFactory2
import org.apache.logging.log4j.scala.{Logging, LoggingContext}

object LoggingApp extends App with Logging {



  val s1 = "foo"
  val s2 = "bar"
  val t = new RuntimeException("This is an error!")

  logger.info(s"Hello, world: $s1 $s2")

  logger.traceEntry()
  logger.traceEntry(s1, s2)
  val entryMessage = logger.traceEntry(logger.delegate.getMessageFactory.asInstanceOf[MessageFactory2].newMessage("foobar": CharSequence))

  logger.traceExit()
  logger.traceExit(s2)
  logger.traceExit(entryMessage):
  logger.traceExit(entryMessage, s2)
  logger.traceExit(logger.delegate.getMessageFactory.asInstanceOf[MessageFactory2].newMessage("bonsai": CharSequence), s2)

  logger.error(s"This is an error message")

  try {
    throw t
    //logger.throwing(t)
    //logger.throwing(Level.INFO, t)
  } catch {
    case rte: Exception => println("ok!!!!")
  } finally {
    println("Here")
  }

  LoggingContext("correlationId") = UUID.randomUUID().toString
  logger.info("Logging with a correlation ID set")
  LoggingContext.clear()
  logger.info("Logging without the correlation ID")
}

```
