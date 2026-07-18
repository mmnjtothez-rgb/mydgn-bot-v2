plugins {

    id("com.android.application")

    id("org.jetbrains.kotlin.android")

    id("org.jetbrains.kotlin.plugin.compose")

    id("com.google.dagger.hilt.android")

    kotlin("kapt")

}


android {

    namespace = "com.mydgnbot"

    compileSdk = 35


    defaultConfig {

        applicationId = "com.mydgnbot"

        minSdk = 26

        targetSdk = 35

        versionCode = 1

        versionName = "1.0"

    }



    buildTypes {

        release {

            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )

        }


        debug {

            applicationIdSuffix = ".debug"

            versionNameSuffix = "-debug"

        }

    }



    buildFeatures {

        compose = true

    }



    compileOptions {

        sourceCompatibility =
            JavaVersion.VERSION_17

        targetCompatibility =
            JavaVersion.VERSION_17

    }



    kotlinOptions {

        jvmTarget = "17"

    }

}



dependencies {


    // -----------------------
    // Android Core
    // -----------------------

    implementation(
        "androidx.core:core-ktx:1.15.0"
    )


    implementation(
        "androidx.activity:activity-compose:1.10.0"
    )



    // -----------------------
    // Compose
    // -----------------------

    implementation(
        platform(
            "androidx.compose:compose-bom:2025.01.00"
        )
    )


    implementation(
        "androidx.compose.ui:ui"
    )


    implementation(
        "androidx.compose.ui:ui-tooling-preview"
    )


    implementation(
        "androidx.compose.material3:material3"
    )


    debugImplementation(
        "androidx.compose.ui:ui-tooling"
    )



    // -----------------------
    // Navigation
    // -----------------------

    implementation(
        "androidx.navigation:navigation-compose:2.8.5"
    )



    // -----------------------
    // Lifecycle
    // -----------------------

    implementation(
        "androidx.lifecycle:lifecycle-runtime-compose:2.8.7"
    )


    implementation(
        "androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7"
    )



    // -----------------------
    // Hilt
    // -----------------------

    implementation(
        "com.google.dagger:hilt-android:2.54"
    )


    kapt(
        "com.google.dagger:hilt-compiler:2.54"
    )


    implementation(
        "androidx.hilt:hilt-navigation-compose:1.2.0"
    )



    // -----------------------
    // Retrofit
    // -----------------------

    implementation(
        "com.squareup.retrofit2:retrofit:2.11.0"
    )


    implementation(
        "com.squareup.retrofit2:converter-gson:2.11.0"
    )



    // -----------------------
    // OkHttp
    // -----------------------

    implementation(
        "com.squareup.okhttp3:okhttp:4.12.0"
    )


    implementation(
        "com.squareup.okhttp3:logging-interceptor:4.12.0"
    )



    // -----------------------
    // Coroutines
    // -----------------------

    implementation(
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.1"
    )

}
