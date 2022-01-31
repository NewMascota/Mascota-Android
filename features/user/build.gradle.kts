plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("org.jlleitschuh.gradle.ktlint")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
}

android {
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(project(":features:home"))
    implementation(project(":core:"))

    // Android Core
    implementation(KotlinDependencies.kotlin)
    implementation(AndroidXDependencies.coreKtx)
    implementation(AndroidXDependencies.appCompat)
    implementation(AndroidXDependencies.constraintLayout)
    implementation(AndroidXDependencies.legacy)
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

    // Jetpack Compose
    implementation(AndroidXDependencies.composeRuntime)

    // ImageLoading Library
    // Glide for general
    // Coil for compose
    implementation(ThirdPartyDependencies.glide)
    kapt(KaptDependencies.glideCompiler)
    implementation(ThirdPartyDependencies.coil)

    // Http Client Library
    implementation(ThirdPartyDependencies.retrofit)
    implementation(platform(ThirdPartyDependencies.okHttpBom))
    implementation(ThirdPartyDependencies.okHttp)
    implementation(ThirdPartyDependencies.okHttpLoggingInterceptor)
    implementation(ThirdPartyDependencies.kotlinxSerializationConverter)

    // Logger - Timber
    implementation(ThirdPartyDependencies.timber)

    // Automatic Record OpenSource Library List
    implementation(ThirdPartyDependencies.ossLicense)

    // kotlinx-serialization-json
    implementation(ThirdPartyDependencies.kotlinxSerializationJsonConverter)

    // lottie
    implementation(ThirdPartyDependencies.lottie)

    // Flipper
    debugApi(ThirdPartyDependencies.flipper)
    debugApi(ThirdPartyDependencies.flipperNetwork)
    debugApi(ThirdPartyDependencies.soloader)
    debugApi(ThirdPartyDependencies.flipperLeakCanary)
    debugApi(ThirdPartyDependencies.leakCanary)

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
