#!/usr/bin/env bash
set -e

echo "▶ Running full test suite..."

BROWSER=${1:-chrome}
ENV=${2:-local}

sbt clean -Dbrowser=$BROWSER -Dbrowser.option.headless=false -Denv=$ENV -Dbrowser.logging=true "testOnly scalaTest.specs.* -- -C scalaTest.utils.ColorfulReporter -oD" testReport
