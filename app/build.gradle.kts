plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.assignment2"
    compileSdk = 36  // Changed from 34 to 36

    defaultConfig {
        applicationId = "com.example.assignment2"
        minSdk = 24
        targetSdk = 36  // Changed from 34 to 36 (can keep as 34 if you want, but better to match compileSdk)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
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
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // Update these dependencies to use compatible versions
    implementation("androidx.core:core-ktx:1.12.0")  // Downgraded from 1.17.0
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.activity:activity-ktx:1.8.2")  // Downgraded from 1.12.1
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.fragment:fragment-ktx:1.6.2")

    // Add Glide for image loading
    implementation("com.github.bumptech.glide:glide:4.16.0")

    // Add for rounded images
    implementation("de.hdodenhof:circleimageview:3.1.0")

    // Remove this if you don't need navigation events
    // implementation("androidx.navigationevent:navigationevent-android:1.0.1")
}