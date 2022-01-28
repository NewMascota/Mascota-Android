plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-kapt")
    kotlin("plugin.serialization") version Versions.kotlinVersion
    id("org.jlleitschuh.gradle.ktlint")
    id("dagger.hilt.android.plugin")
}

android {
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    // Android Core
    implementation(KotlinDependencies.kotlin)
    implementation(AndroidXDependencies.coreKtx)
    implementation(AndroidXDependencies.appCompat)
    implementation(AndroidXDependencies.constraintLayout)
    implementation(AndroidXDependencies.coroutines)

    // Material Design
    implementation(MaterialDesignDependencies.materialDesign)

    // Dagger-Hilt
    implementation(AndroidXDependencies.hilt)
    kapt(KaptDependencies.hiltCompiler)

    // Jetpack Navigation Component
    implementation(AndroidXDependencies.navigationFragment)
    implementation(AndroidXDependencies.navigationUI)

    // Jetpack Security
    implementation(AndroidXDependencies.security)

    // Jetpack Fragment
    implementation(AndroidXDependencies.fragment)

    // Jetpack Lifecycle
    implementation(AndroidXDependencies.coroutines)
    implementation(AndroidXDependencies.lifeCycleKtx)
    implementation(AndroidXDependencies.lifecycleJava8)

    // ImageLoading Library
    // Glide for general
    implementation(ThirdPartyDependencies.glide)
    kapt(KaptDependencies.glideCompiler)

    // Http Client Library
    implementation(ThirdPartyDependencies.retrofit)
    implementation(platform(ThirdPartyDependencies.okHttpBom))
    implementation(ThirdPartyDependencies.okHttp)
    implementation(ThirdPartyDependencies.okHttpLoggingInterceptor)
    implementation(ThirdPartyDependencies.kotlinxSerializationConverter)

    // Automatic Record OpenSource Library List
    implementation(ThirdPartyDependencies.ossLicense)

    // kotlinx-serialization-json
    implementation(ThirdPartyDependencies.kotlinxSerializationJsonConverter)

    // Test Dependency
    testImplementation(TestDependencies.androidTest)
    testImplementation(TestDependencies.jUnit)
    testImplementation(TestDependencies.espresso)
}

ktlint {
    android.set(true)
    coloredOutput.set(true)
    verbose.set(true)
    outputToConsole.set(true)
}
