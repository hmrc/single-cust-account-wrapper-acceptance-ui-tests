import sbt.*

object Dependencies {

  val test: Seq[ModuleID] = Seq(
    "io.cucumber"           % "cucumber-junit"            % "7.16.1"    % Test,
    "junit"                 % "junit"                     % "4.13.2"    % Test,
    "log4j"                 % "log4j"                     % "1.2.17"    % Test,
    "io.cucumber"           %% "cucumber-scala"           % "8.26.2"    % Test,
    "uk.gov.hmrc"           %% "ui-test-runner"           % "0.45.0"    % Test,
    "org.playframework"     %% "play-test"                % "3.0.5"     % Test,
    "com.typesafe.play"     %% "play-ws-standalone-json"  % "2.2.9"    % Test,
    "com.typesafe.play"     %% "play-ahc-ws-standalone"   % "2.2.9"    % Test,
    "org.mongodb.scala"     %% "mongo-scala-driver"       % "5.1.1" cross CrossVersion.for3Use2_13,
    "org.scalaj"            %% "scalaj-http"              % "2.4.2"  cross CrossVersion.for3Use2_13,
  )
}
