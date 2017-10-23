lazy val sbtplugin =
  (project in file(".")).settings(
      name := "sbtplugin",
      organization := "au.com.icx",
    scalaVersion := "2.12.4",
      sbtPlugin := true,
      scalacOptions ++= Seq(
          "-unchecked",
          "-deprecation",
          "-feature",
          "-encoding",
          "UTF-8"
      ),
      publishTo := Some(
          "icx realm" at "https://sbt.icx.com.au/artifactory/sbt-release;build.timestamp=" + new java.util.Date().getTime),
    credentials += Credentials(Path.userHome / ".sbt" / "artifactory.credentials")
  )
