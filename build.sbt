import sbt.Keys.organization

lazy val `sbtplubin` =
  project
    .in(file("."))
    .settings(name := """sbtplugin""",
      organization := "au.com.icx",
version := "0.0.03",
scalaVersion := "2.12.3",
sbtPlugin := true,
resolvers += "au.com.icx" at "s3://s3-ap-southeast-2.amazonaws.com/au.com.icx.resolver/snapshots",
publishMavenStyle := true,
publishTo := Some(
  "au.com.icx" at "s3://s3-ap-southeast-2.amazonaws.com/au.com.icx.resolver/snapshots"),
scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-target:jvm-1.8",
  "-encoding", "UTF-8"
))


