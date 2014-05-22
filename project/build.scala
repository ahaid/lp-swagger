
import org.scalatra.sbt._
import com.mojolly.scalate.ScalatePlugin._
import ScalateKeys._
import sbt._
import sbt.Keys._
import scala.Some
import spray.revolver.RevolverPlugin._
import org.scalastyle.sbt.ScalastylePlugin


object Resolvers {


}

object Dependencies {
  val mysqlDriver = "mysql" % "mysql-connector-java" % "5.1.10"

  val ScalatraVersion = "2.3.0.RC3"

  val appDependencies = Seq(
    // third party managed dependencies
    "org.scalatra"            %% "scalatra"             % ScalatraVersion,
    "org.scalatra"            %% "scalatra-scalate"     % ScalatraVersion,
    "org.scalatra"            %% "scalatra-swagger"     % ScalatraVersion,
    "org.scalatra"            %% "scalatra-json"        % ScalatraVersion,

    "org.eclipse.jetty"       % "jetty-webapp"          % "8.1.8.v20121106"     % "container;provided;test",
    "org.eclipse.jetty.orbit" % "javax.servlet"         % "3.0.0.v201112011016" % "container;provided;test" artifacts (Artifact("javax.servlet", "jar", "jar")),
    "org.json4s"              %% "json4s-jackson"       % "3.2.10",
    "org.json4s"              %% "json4s-native"        % "3.2.10",

    // test dependencies
    "org.scalatra"      %% "scalatra-scalatest"   % ScalatraVersion   % "test",
    "org.scalatest"     % "scalatest_2.10"        % "2.1.0"           % "test",
    "org.mockito"       % "mockito-core"          % "1.9.0"           % "test"

  )
}

object BuildSettings {

  val buildOrganization = "com.ahaid"
  val appName = "lp-swagger"
  val buildVersion = "0.0.1-SNAPSHOT"
  val buildScalaVersion = "2.10.4"
  val buildScalaOptions = Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-Xlint")

  import Dependencies._

  val buildSettings = Defaults.defaultSettings ++ Seq(
    organization := buildOrganization,
    version := buildVersion,
    scalaVersion := buildScalaVersion,
    libraryDependencies := appDependencies,
    scalacOptions := buildScalaOptions,
    ivyLoggingLevel := UpdateLogging.Full,
     scalateTemplateConfig in Compile <<= (sourceDirectory in Compile){ base =>
      Seq(
        TemplateConfig(
          base / "webapp" / "WEB-INF" / "templates",
          Seq.empty,  /* default imports should be added here */
          Seq(
            Binding("context", "_root_.org.scalatra.scalate.ScalatraRenderContext", importMembers = true, isImplicit = true)
          ),  /* add extra bindings here */
          Some("templates")
        )
      )
    }
  ) ++ Revolver.settings ++ ScalastylePlugin.Settings ++ ScoverageSbtPlugin.instrumentSettings ++ ScalatraPlugin.scalatraWithJRebel ++ scalateSettings
}

object ApplicationBuild extends Build {

  import BuildSettings._

  lazy val main = Project(
    appName,
    file("."),
    settings = buildSettings)
}
