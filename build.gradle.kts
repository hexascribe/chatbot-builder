plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    kotlin("android").version(libs.versions.kotlin).apply(false)
    kotlin("jvm").version(libs.versions.kotlin).apply(false)
    kotlin("multiplatform").version(libs.versions.kotlin).apply(false)
    id("com.vanniktech.maven.publish").version(libs.versions.publishPlugin).apply(false)
    id("com.android.application").version(libs.versions.gradlePlugin).apply(false)
    id("com.android.library").version(libs.versions.gradlePlugin).apply(false)
    id("org.jetbrains.compose").version(libs.versions.composePlugin).apply(false)
}
