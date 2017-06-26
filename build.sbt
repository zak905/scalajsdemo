enablePlugins(ScalaJSPlugin)

name := "scalajsdemo"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.1"
)

scalaJSUseMainModuleInitializer := true
