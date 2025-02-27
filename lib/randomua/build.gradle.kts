import org.gradle.api.JavaVersion

plugins {
    id("com.android.library") // ✅ Android Library Plugin
    id("kotlin-android") // ✅ Kotlin Plugin for Android
}

android {
    compileSdk = 34

    defaultConfig {
        minSdk = 21
        targetSdk = 34
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        viewBinding = true // ✅ Enable ViewBinding
    }
}

dependencies {
    implementation("eu.kanade.tachiyomi:injekt:0.0.4") // ✅ Correct injekt-core dependency
}


