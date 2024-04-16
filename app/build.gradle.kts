plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.moony.petsgo"
    compileSdk = 34

    viewBinding{
        enable=true
    }

    defaultConfig {
        applicationId = "com.moony.petsgo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //implementation(libs.androidx.core.ktx)
    //implementation(libs.androidx.lifecycle.runtime.ktx)
    //implementation(libs.androidx.activity.compose)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //hilt
    implementation(libs.androidx.hilt.navigation.fragment)
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    //navigation


    implementation (libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)


    //by viewModels
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.fragment.ktx)

    //implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    //noinspection UseTomlInstead
    //implementation("androidx.compose.ui:ui")
    //noinspection UseTomlInstead
    //implementation("androidx.compose.ui:ui-graphics")
    //noinspection UseTomlInstead
    //implementation("androidx.compose.ui:ui-tooling-preview")
    //noinspection UseTomlInstead
    //implementation("androidx.compose.material3:material3")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    //noinspection UseTomlInstead
    //androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    //noinspection UseTomlInstead
    //debugImplementation("androidx.compose.ui:ui-tooling")
    //noinspection UseTomlInstead
    //debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation(project(":feature:test_home"))
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}