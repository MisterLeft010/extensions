plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlinx-serialization")
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
    }

    namespace = "eu.kanade.tachiyomi.lib.randomua"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.github.inorichi.injekt:injekt-core:0.0.4") // ✅ Use a stable version
}

