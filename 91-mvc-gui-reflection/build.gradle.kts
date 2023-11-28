plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "0.40.0"
}

application {
    mainClass.set("it.unibo.mvc.LaunchApp")
}

tasks.javadoc {
    isFailOnError = false
}
