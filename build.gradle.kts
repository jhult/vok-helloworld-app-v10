import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.2.71"
    id("org.gretty") version "2.2.0"
}

defaultTasks("clean", "build")

allprojects {
    group = "com.example.vok"
    version = "1.0-SNAPSHOT"
    repositories {
        jcenter()
        maven { setUrl("https://dl.bintray.com/mvysny/github") }
    }
}

subprojects {
    apply { plugin("kotlin") }
    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    tasks.withType<Test> {
        useJUnitPlatform()
        testLogging {
            // to see the exceptions of failed tests in Travis-CI console.
            exceptionFormat = TestExceptionFormat.FULL
        }
    }
}