buildscript {
    repositories {
        mavenCentral()
        google()
        maven(url = "https://plugins.gradle.org/m2/")
    }
plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {
    implementation("eu.kanade.tachiyomi:injekt:0.0.4")
}
}

allprojects {
    repositories {
        mavenCentral()
        google()
        maven(url = "https://jitpack.io")
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory.asFile.get())
}
