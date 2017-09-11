package au.com.icx.sbtplugin

import sbt._
import sbt.Keys._

object SbtpluginPlugin extends AutoPlugin {

  val freshOrganization: SettingKey[String] =
    settingKey(s"""Build organization –  by default""")

  override def trigger = allRequirements
  override lazy val projectSettings = Seq(
    freshOrganization := "com.example"
  )
}
