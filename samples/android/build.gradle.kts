import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose)
}

android {
    compileSdk = libs.versions.compile.sdk.get().toInt()
    namespace = "com.hexascribe.chatbotbuilder"

    defaultConfig {
        applicationId = "com.hexascribe.chatbotbuilder"
        minSdk = libs.versions.min.sdk.get().toInt()
        targetSdk = libs.versions.target.sdk.get().toInt()
        versionCode = 1
        versionName = "1.0"

        val errorMessage =
            "API key not found. Please insert the api.key in the System environment or inside local.properties file."
        val key = "api.key"
        val apiKey = System
            .getenv()
            .getOrDefault(
                key, gradleLocalProperties(rootDir)[key]
                    ?: throw IllegalArgumentException(errorMessage)
            )
        buildConfigField("String", "API_KEY", "\"$apiKey\"")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":chatbot-builder"))
    implementation(libs.activity.compose)
    implementation(libs.app.compat)
}
