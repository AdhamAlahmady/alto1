plugins {
id("com.android.application")
kotlin("android")
}

android {
namespace = "com.example.inventory"
compileSdk = 34

defaultConfig {
applicationId = "com.example.inventory"
minSdk = 21
targetSdk = 34
versionCode = 1
versionName = "1.0"
}
}

dependencies {

implementation("androidx.appcompat:appcompat:1.6.1")
implementation("com.google.android.material:material:1.11.0")

implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")

implementation("com.journeyapps:zxing-android-embedded:4.3.0")

implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

}