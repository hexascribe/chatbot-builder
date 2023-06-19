plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
}

kotlin {
    android()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        name = "ChatBotBuilder"
        version = "0.0.1"
        authors = "Ars Techna"
        summary = "ChatBot Builder is a SDK that you can seamlessly customize the Chat UI to match the look and feel of your application, while also having the ability to define specific instructions for the bots behavior."
        license = "LICENSE"
        homepage = "https://github.com/ars-techna/chatbot-builder"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../samples/ios/Podfile")
        framework {
            baseName = "ChatBotBuilder"
            isStatic = true
        }
        extraSpecAttributes["resources"] = "['src/commonMain/resources/**', 'src/iosMain/resources/**']"
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(libs.ychat)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(compose.uiTooling)
                implementation(compose.preview)
                implementation(libs.activity.compose)
                implementation(libs.core.ktx)
                implementation(libs.app.compat)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
    }
}

android {
    compileSdk = libs.versions.compile.sdk.get().toInt()
    namespace = "com.arstechna.chatbotbuilder"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = libs.versions.min.sdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        jvmToolchain(11)
    }
    buildFeatures {
        compose = true
    }
}
