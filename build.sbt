organization := "ru.detmir"
name := "backend-email-flow"
version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.8"

fork := true
javaOptions in run += "-Xmx4G"
retrieveManaged := true

// Scala
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.7",
  "com.typesafe.akka" %% "akka-stream" % "2.5.7",
//  "com.typesafe.akka" %% "akka-http" % "10.0.11",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.7" % Test,
  "com.typesafe.akka" %% "akka-stream-testkit" % "2.5.7" % Test,
  "org.scalatest" %% "scalatest" % "3.0.4" % Test,
  "org.scalamock" %% "scalamock" % "4.0.0"

)



