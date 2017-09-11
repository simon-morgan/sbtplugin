import sbt.Keys.organization

lazy val `sbtplubin` =
  project
    .in(file("."))
    .settings(name := """sbtplugin""",
      organization := "au.com.icx",
      version := "0.0.11",
      crossSbtVersions := List("0.13.16", "1.0.1"),
      scalaVersion := (CrossVersion partialVersion sbtCrossVersion.value match {
        case Some((0, 13)) => "2.10.6"
        case Some((1, _)) => "2.12.3"
        case _ => sys error s"Unhandled sbt version ${sbtCrossVersion.value}"
      }),
      sbtPlugin := true,
      scalacOptions ++= Seq(
        "-unchecked",
        "-deprecation",
        "-feature",
        "-encoding", "UTF-8"
      ))

val sbtCrossVersion = sbtVersion in pluginCrossBuild
