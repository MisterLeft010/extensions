buildscript {
    repositories {
        mavenCentral()
        google()
        maven(url = "https://plugins.gradle.org/m2/")
    }
plugins {
    id("com.android.library") // ✅ Required for an Android library
    id("org.jetbrains.kotlin.android") // ✅ Required for Kotlin Android projects
}

android {
    compileSdk = 34

    defaultConfig {
        minSdk = 21
        targetSdk = 34
    }

    buildFeatures {
        viewBinding = true // ✅ Enable ViewBinding if needed
    }
}

dependencies {
    implementation("eu.kanade.tachiyomi:injekt:0.0.4") // ✅ Correct injekt dependency
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
