# sbtplugin

An sbt AutoPlugin

## Usage

This plugin requires sbt 0.13.16 or sbt 1.0.1

In ```project/plugins.sbt``` include the following (change version number as appropriate)

```sbtshell
resolvers += Resolver.bintrayIvyRepo("simon-morgan", "sbt-plugins")

addSbtPlugin("au.com.icx"         % "sbtplugin"          % "0.0.11")

```