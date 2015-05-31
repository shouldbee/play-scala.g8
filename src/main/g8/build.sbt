name := """$name;format="normalize"$"""

version := "$version$"

lazy val root = (project in file(".")).enablePlugins(PlayScala, SbtWeb)

scalaVersion := "$scala_version$"

scalacOptions := Seq(
  "-deprecation",
  "-encoding", "utf8",
  "-feature",
  "-language:higherKinds",
  "-unchecked",
  "-Xlint",
  "-Xfatal-warnings",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  //"-Ywarn-unused",
  //"-Ywarn-unused-import",
  "-Ywarn-value-discard"
)

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  filters,
  "com.mohiva" %% "play-html-compressor" % "0.3.1"
)

// Databases
libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "5.1.35",
  "org.scalikejdbc" %% "scalikejdbc"                      % "2.2.+",
  "org.scalikejdbc" %% "scalikejdbc-syntax-support-macro" % "2.2.+"
)

// Scalariform settings
import scalariform.formatter.preferences._

scalariformSettings

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(PreserveDanglingCloseParenthesis, true)

// Scalastyle settings
lazy val compileScalastyle = taskKey[Unit]("compileScalastyle")

compileScalastyle := org.scalastyle.sbt.ScalastylePlugin.scalastyle.in(Compile).toTask("").value

(compile in Compile) <<= (compile in Compile) dependsOn compileScalastyle

// Scapegoat settings
scapegoatIgnoredFiles := Seq(
  ".*/controllers/ReverseRoutes.scala",
  ".*/controllers/javascript/JavaScriptReverseRoutes.scala",
  ".*/router/Routes.scala",
  ".*/.*template.scala"
)

// Reloading assets on `activator run`
play.PlayImport.PlayKeys.playRunHooks ++= Seq(
  RunSubProcess("make watch")
)

// Remove unnecessary assets source files from assets.jar.
pipelineStages := Seq(filter)

includeFilter in filter := "*.ts" || "*.coffee" || "*.less" || "*.sass" || "*.styl" || "*.jade" || "*.jsx" // filter files from production build

// Run `make build` before `activator dist`
lazy val webpackBuild = taskKey[Unit]("Build production js bundle.")

webpackBuild := {
  "make build" !
}

(packageBin in Universal) <<= (packageBin in Universal) dependsOn webpackBuild

// Disable documentation to speed up compilation
sources in (Compile, doc) := Seq.empty

publishArtifact in (Compile, packageDoc) := false
