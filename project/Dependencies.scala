import sbt.*

object Dependencies {

  val test: Seq[ModuleID] = Seq(
    "io.cucumber"           % "cucumber-junit"            % "7.16.1"    % Test,
    "junit"                 % "junit"                     % "4.13.2"    % Test,
    "log4j"                 % "log4j"                     % "1.2.17"    % Test,
    "io.cucumber"           %% "cucumber-scala"           % "8.21.1"    % Test,
    "io.cucumber"           % "cucumber-core"             % "7.11.1"    % Test,
    "uk.gov.hmrc"           %% "ui-test-runner"           % "0.42.0"    % Test,
    "org.playframework"     %% "play-test"                % "3.0.5"     % Test,
    "com.typesafe.play"     %% "play-ws-standalone-json"  % "2.1.11"    % Test,
    "com.typesafe.play"     %% "play-ahc-ws-standalone"   % "2.1.11"    % Test,
    "org.scalaj"            %% "scalaj-http"              % "2.4.2"     % Test,
    "org.mongodb.scala"     %% "mongo-scala-driver"       % "4.9.1"     % Test
  )
}
