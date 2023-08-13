import sbt._

object Dependencies {
  lazy val scalaTest: ModuleID = "org.scalatest" %% "scalatest" % "3.2.15"
  lazy val mockito: ModuleID = "org.scalatestplus" %% "mockito-4-6" % "3.2.15.0"
  lazy val assertj: ModuleID = "org.assertj" % "assertj-core" % "3.24.2"
}
