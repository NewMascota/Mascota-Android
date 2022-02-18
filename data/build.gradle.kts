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
    implementation(AndroidXDependencies.coroutines)

    // Dagger-Hilt
    implementation(AndroidXDependencies.hilt)
    kapt(KaptDependencies.hiltCompiler)

    // Jetpack Security
    implementation(AndroidXDependencies.security)

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
