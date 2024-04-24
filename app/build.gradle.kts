plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("maven-publish")
}

//configurations.maybeCreate("default")
//artifacts.add("default", file("linphone-5.3.24.aar"))

android {
    namespace = "com.example.linphones"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    artifacts {
        file("linphone-5.3.24.aar")
    }
}

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.github.kapilkori"
            artifactId = "linphone-sdk"
            version = "0.0.1"

            artifact(file("linphone-5.3.24.aar"))
        }
    }
}
