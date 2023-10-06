plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("kapt") version "1.5.21"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
kapt {
    correctErrorTypes = true
}
dependencies {
    testImplementation(kotlin("test"))
    kapt ("com.google.dagger:dagger-compiler:2.48")
    implementation ("com.google.dagger:dagger:2.48")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}