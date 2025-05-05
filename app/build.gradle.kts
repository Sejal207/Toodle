plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.madfinal"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.madfinal"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    // AndroidX and Material Design
    implementation(libs.appcompat)
    implementation(libs.material)  // This is your Material Design dependency
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // Lottie Animation
    implementation(libs.lottie)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}