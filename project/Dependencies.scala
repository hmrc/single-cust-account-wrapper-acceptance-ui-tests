import sbt.*

object Dependencies {

  val test: Seq[ModuleID] = Seq(
    "io.cucumber"           % "cucumber-junit"            % "7.16.1"    % Test,
    "io.cucumber"           %% "cucumber-scala"           % "8.26.2"    % Test,
    "uk.gov.hmrc"           %% "ui-test-runner"           % "0.46.0"    % Test,
    "org.playframework"     %% "play-test"                % "3.0.5"     % Test,
    "org.mongodb.scala"     %% "mongo-scala-driver"       % "5.1.1" cross CrossVersion.for3Use2_13,
    "org.scalaj"            %% "scalaj-http"              % "2.4.2"  cross CrossVersion.for3Use2_13,
  )
}
