package au.com.icx.sbtplugin

import sbt.{addSbtPlugin, _}
import sbt.Keys._

object SbtpluginPlugin extends AutoPlugin {
  object Deps {
    val libs: Def.Setting[_] =
      libraryDependencies ++= Seq(
          "org.typelevel" %% "cats"      % "0.9.0",
          "com.chuusai"   %% "shapeless" % "2.3.2",
          "org.scalatest" %% "scalatest" % "3.0.3" % Test
      )

    val scalaCopts = scalacOptions ++= Seq(
        "-feature",
        "-language:higherKinds",
        "-language:implicitConversions",
        "-target:jvm-1.8",
        "-encoding",
        "UTF-8",
        "-unchecked",
        "-deprecation",
        "-Xfuture",
        "-Yno-adapted-args",
        "-Ywarn-dead-code",
        "-Ywarn-numeric-widen",
        "-Ywarn-value-discard",
        "-Ywarn-unused",
        "-Ypartial-unification"
    )

  }

  override def trigger = allRequirements
  override lazy val projectSettings = Seq[Def.Setting[_]](
      scalaVersion := "2.12.3",
      Deps.libs,
      Deps.scalaCopts,
      publishMavenStyle := true,
      publishTo := Some(
          "au.com.icx" at "s3://s3-ap-southeast-2.amazonaws.com/au.com.icx.resolver/snapshots")
  )

}
