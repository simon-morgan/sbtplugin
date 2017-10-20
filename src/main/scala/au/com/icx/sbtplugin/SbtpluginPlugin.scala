package au.com.icx.sbtplugin

import sbt.{addSbtPlugin, _}
import sbt.Keys._

object SbtpluginPlugin extends AutoPlugin {
  object Deps {
    val libs: Def.Setting[_] =
      libraryDependencies ++= Seq(
          "org.typelevel" %% "cats" % "0.9.0",
          "com.chuusai" %% "shapeless" % "2.3.2",
          "org.scalatest" %% "scalatest" % "3.0.3" % Test
      )

    val scalafmtOnCompile = settingKey[Boolean]("format scala on compile")

    val scalaCopts = scalacOptions ++= Seq(
        "-feature",
        "-language:higherKinds",
        "-language:implicitConversions",
        "-language:postfixOps",
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
      organization := "au.com.icx",
      Deps.scalafmtOnCompile := true,
      Deps.libs,
      Deps.scalaCopts,
      resolvers in Global += "au.com.icx" at "https://sbt.icx.com.au/artifactory/sbt-release/",
      publishTo := Some(
          "Artifactory Realm" at "https://sbt.icx.com.au/artifactory/sbt-release;build.timestamp=" + new java.util.Date().getTime),
      credentials in Global += Credentials(Path.userHome / ".sbt" / "artifactory.credentials")
  )

}
