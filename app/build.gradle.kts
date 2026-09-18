// Plain desktop Gradle — see AGENTS.md.
//
// This was a CodeAssist project up to v1.1.0 (built from app/module.toml, which
// is now retired from the repo). From here the build is ordinary Gradle.

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.spizganed.quickbuds"
    compileSdk = 36

    defaultConfig {
        minSdk = 26
        targetSdk = 35

        // versionCode / versionName are deliberately NOT set here.
        //
        // They live in app/src/main/AndroidManifest.xml so there is exactly one
        // place to edit, and so the value the release is tagged against cannot
        // drift from the value the app reports. AGP merges the manifest's
        // declaration into the built APK, which is what PackageManager reads.
        //
        // This project has already had the two disagree once: a build declared
        // 0.4.0 in the manifest while the release was tagged 1.0.0. Setting a
        // number here as well would reintroduce exactly that split. The manifest
        // is the authority — see AGENTS.md.
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // buildConfig is NOT enabled, deliberately.
    //
    // UpdateActivity reads the installed version through PackageManager, because
    // BuildConfig was not guaranteed to exist when the build script was
    // generated. Enabling it now would create a second, unused source of the
    // version number. Leave it off unless something genuinely needs BuildConfig.
    buildFeatures {
        buildConfig = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_1_8)
    }
}

dependencies {
    implementation("androidx.core:core:1.13.1")
}
