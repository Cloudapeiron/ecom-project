#!/usr/bin/env sh
DEFAULT_JVM_OPTS=""
APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`
CLASSPATH=`dirname "$0"`/gradle/wrapper/gradle-wrapper.jar
if [ -z "$JAVA_HOME" ]; then
  JAVA="java"
else
  JAVA="$JAVA_HOME/bin/java"
fi
exec "$JAVA" $DEFAULT_JVM_OPTS -cp "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
