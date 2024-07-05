import sbt.*

object Dependencies {

  val test: Seq[ModuleID] = Seq(
    "io.cucumber"           % "cucumber-junit"            % "7.11.2"    % Test,
    "junit"                 % "junit"                     % "4.13.2"    % Test,
    "log4j"                 % "log4j"                     % "1.2.17"    % Test,
    "com.typesafe.play"     %% "play-json"                % "2.9.4"     % Test,
    "io.cucumber"           %% "cucumber-scala"           % "8.14.2"    % Test,
    "io.cucumber"           % "cucumber-core"             % "7.11.1"    % Test,
    "org.scalatest"         %% "scalatest"                % "3.2.17"    % Test,
    "uk.gov.hmrc"           %% "ui-test-runner"           % "0.30.0"    % Test,
    "com.typesafe.play"     %% "play-test"                % "2.8.12"    % Test,
    "com.typesafe.play"     %% "play-ws-standalone-json"  % "2.1.2"     % Test,
    "com.typesafe.play"     %% "play-ahc-ws-standalone"   % "2.1.2"     % Test,
    "org.scalaj"            %% "scalaj-http"              % "2.4.2"     % Test,
    "org.mongodb.scala"     %% "mongo-scala-driver"       % "4.9.1"     % Test,
  )
}
