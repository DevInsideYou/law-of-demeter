import Dependencies._
import Util._

ThisBuild / organization := "dev.insideyou"
ThisBuild / scalaVersion := "3.1.1"

ThisBuild / scalacOptions ++=
  Seq(
    "-deprecation",
    "-feature",
    "-language:implicitConversions",
    "-unchecked",
    "-Xfatal-warnings",
    "-Yexplicit-nulls", // experimental (I've seen it cause issues with circe)
    "-Ykind-projector",
    "-Ysafe-init", // experimental (I've seen it cause issues with circe)
  ) ++ Seq("-rewrite", "-indent") ++ Seq("-source", "future")

lazy val playground =
  project
    .in(file("."))
    .settings(name := "playground")
    .settings(commonSettings)
    .aggregate(core, `core-self`, delivery, google, storage, main)

lazy val core =
  project
    .in(file("01-core"))
    .settings(commonSettings)
    .settings(dependencies)

lazy val `core-self` =
  project
    .in(file("02-core-self"))
    .settings(commonSettings)
    .dependsOn(core % Cctt)

lazy val delivery =
  project
    .in(file("02-delivery"))
    .settings(commonSettings)
    .dependsOn(core % Cctt)

lazy val google =
  project
    .in(file("02-google"))
    .settings(commonSettings)
    .dependsOn(core % Cctt)

lazy val storage =
  project
    .in(file("02-storage"))
    .settings(commonSettings)
    .dependsOn(core % Cctt)

lazy val main =
  project
    .in(file("03-main"))
    .settings(commonSettings)
    .dependsOn(`core-self` % Cctt)
    .dependsOn(delivery % Cctt)
    .dependsOn(google % Cctt)
    .dependsOn(storage % Cctt)

lazy val commonSettings = commonScalacOptions ++ Seq(
  update / evictionWarningOptions := EvictionWarningOptions.empty
)

lazy val commonScalacOptions = Seq(
  Compile / console / scalacOptions --= Seq(
    "-Wunused:_",
    "-Xfatal-warnings",
  ),
  Test / console / scalacOptions :=
    (Compile / console / scalacOptions).value,
)

lazy val dependencies = Seq(
  libraryDependencies ++= Seq(
    // main dependencies
  ),
  libraryDependencies ++= Seq(
    org.scalatest.scalatest,
    org.scalatestplus.`scalacheck-1-15`,
  ).map(_ % Test),
)
