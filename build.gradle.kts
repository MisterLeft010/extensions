buildscript {
    repositories {
        mavenCentral()
        google()
        maven(url = "https://plugins.gradle.org/m2/")
    }
plugins {
    id("com.android.library") // ✅ Required for Android projects
    id("org.jetbrains.kotlin.android") // ✅ Kotlin plugin
}

android {
    namespace = "your.extension.package" // Replace with actual package name
    compileSdk = 34

    defaultConfig {
        minSdk = 21
        targetSdk = 34
    }
}

dependencies {
    implementation("eu.kanade.tachiyomi:injekt:0.0.4") // ✅ Correct dependency
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
