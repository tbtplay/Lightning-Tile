plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.lightningtile"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.lightningtile"
        minSdk = 30
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation("dev.rikka.shizuku:api:13.1.5")
    implementation("dev.rikka.shizuku:provider:13.1.5")
}
