import sbt._

object Dependencies {
  val test: Seq[ModuleID] = Seq(
    "uk.gov.hmrc"         %% "webdriver-factory"       % "0.46.0",
    "org.scalatest"       %% "scalatest"               % "3.2.17",
    "org.scalatestplus"   %% "selenium-4-12"           % "3.2.17.0",
    "com.vladsch.flexmark" % "flexmark-all"            % "0.62.2",
    "io.cucumber"         %% "cucumber-scala"          % "6.9.1",
    "io.cucumber"          % "cucumber-junit"          % "6.9.1",
    "junit"                % "junit"                   % "4.12",
    "com.novocode"         % "junit-interface"         % "0.11",
    "com.typesafe"         % "config"                  % "1.4.2",
    "com.typesafe.play"   %% "play-ws-standalone-json" % "2.1.2",
    "com.typesafe.play"   %% "play-ahc-ws-standalone"  % "2.1.2",
    "org.scalaj"          %% "scalaj-http"             % "2.4.2"
  ).map(_ % Test)
}
