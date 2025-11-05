
import com.android.build.gradle.BaseExtension

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlin.compose) // Compose Compiler Gradle plugin required from Kotlin 2.0
    alias(libs.plugins.kotlin)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    id("jacoco")
}
tasks.withType<Test> {
    extensions.configure(JacocoTaskExtension::class) {
        isIncludeNoLocationClasses = true
        excludes = listOf("jdk.internal.*")
    }
}
android {
    namespace = "com.kirabium.relayance"
    compileSdk = 36

    testCoverage {
        version = "0.8.8"
    }

//    fun getInstrumentation(): String {
//        return if (project.hasProperty("cucumber")) {
//            "com.kirabium.relayance.runner.MyCucumberTestRunner"
//        } else {
//            "androidx.test.runner.AndroidJUnitRunner"
//        }
//    }

    defaultConfig {
        applicationId = "com.kirabium.relayance"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        //_ allow choice between jUnit runner and cucumber one:
//        testInstrumentationRunner = getInstrumentation()
//        testInstrumentationRunner = "com.kirabium.relayance.runner.MyCucumberTestRunner"
        testInstrumentationRunner = "com.kirabium.relayance.test.MyCucumberTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

//    sourceSets {
//        androidTest {
//            assets.srcDirs += files("src/androidTest/assets")
//        }
//    }

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
        debug {
            enableAndroidTestCoverage = true
            enableUnitTestCoverage = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
//_ Ensure use an emulator for android tests
tasks.register("ensureEmulator") {
    doFirst {
        val adbOutput = ProcessBuilder("adb", "devices")
            .redirectErrorStream(true)
            .start()
            .inputStream
            .bufferedReader()
            .readText()

        val connectedDevices = adbOutput.lines()
            .filter { it.isNotBlank() && !it.startsWith("List") && it.contains("device") }

        val emulators = connectedDevices.filter { it.startsWith("emulator-") }

        if (emulators.isEmpty()) {
            throw GradleException("❌ No emulator detected. Please start one before running tests.")
        }

        if (connectedDevices.size > emulators.size) {
            throw GradleException("⚠️ Physical device(s) detected. Disconnect them to run tests only on emulator.")
        }

        println("✅ Emulator detected (${emulators.joinToString()}). Proceeding with tests.")
    }
}

val androidExtension = extensions.getByType<BaseExtension>()

//_ setup a jacoco test report task including unit tests, android tests and global coverage:
val jacocoTestReport by tasks.registering(JacocoReport::class) {
    dependsOn("clean" , "ensureEmulator", "testDebugUnitTest", "createDebugCoverageReport")
    group = "Reporting"
    description = "Generate Jacoco coverage reports"

    reports {
        csv.required.set(false)
        xml.required.set(true)
        html.required.set(true)
    }

    val debugTree = fileTree("${buildDir}/tmp/kotlin-classes/debug")
    val mainSrc = androidExtension.sourceSets.getByName("main").java.srcDirs

    classDirectories.setFrom(debugTree)
    sourceDirectories.setFrom(files(mainSrc))
    executionData.setFrom(fileTree(buildDir) {
        include("**/*.exec", "**/*.ec")
    })
}

//_ The JacocoCoverageVerification task can be used to verify if code coverage metrics are met
val jacocoTestCoverageCheck by tasks.registering(JacocoCoverageVerification::class) {
    dependsOn("clean" , "ensureEmulator","testDebugUnitTest", "createDebugCoverageReport")
    group = "Verification"
    description = "Verifies code coverage metrics"

    val debugTree = fileTree("${buildDir}/tmp/kotlin-classes/debug")
    val mainSrc = androidExtension.sourceSets.getByName("main").java.srcDirs

    classDirectories.setFrom(debugTree)
    sourceDirectories.setFrom(files(mainSrc))
    executionData.setFrom(fileTree(buildDir) {
        include("**/*.exec", "**/*.ec")
    })

    violationRules {
        rule {
            isEnabled = true
            limit {
                minimum = "0.5".toBigDecimal() // 50% minimum coverage
            }
        }

        rule {
            isEnabled = true
            element = "CLASS"
            limit {
                counter = "LINE"
                value = "COVEREDRATIO"
                minimum = "0.5".toBigDecimal() // each class must have ≥ 50% line coverage
            }
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    //_ icons
    implementation(libs.material.icons.core)
    implementation(libs.material.icons.extended)
    //_ oliviermarteaux
    implementation(libs.oliviermarteaux.compose)
    implementation(libs.oliviermarteaux.core)
    //_ navigation
    implementation(libs.navigation.compose)
    //_ hilt
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    //_ UNIT TESTS
    testImplementation(libs.junit)
    //_ cucumber for UnitTests
    testImplementation(libs.cucumber.java)
    testImplementation(libs.cucumber.junit)
    testImplementation(libs.cucumber.picocontainer)

    //_ ANDROID TESTS
    androidTestImplementation(libs.androidx.test.core)        // ActivityScenario support
    androidTestImplementation(libs.androidx.test.rules)                 // ActivityScenarioRule (optional)
    androidTestImplementation(libs.androidx.test.espresso.contrib)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.test.espresso.intents)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.ext.junit.ktx)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    //_ cucumber for AndroidTests
    androidTestImplementation(libs.cucumber.android)
    androidTestImplementation(libs.cucumber.junit)
    androidTestImplementation(libs.cucumber.picocontainer)
    androidTestImplementation(libs.cucumber.messages)
    androidTestImplementation(kotlin("stdlib"))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}

/**
 *_ Helper function to force application run to be performed on physical device.
 */
val targetDevice = "adb-cb4d0d70-D3BuA7._adb-tls-connect._tcp" // ← Replace with your actual device ID
val checkPhysicalDevice = tasks.register("checkPhysicalDevice") {
    doFirst {
        val adbOutput = ProcessBuilder("adb", "devices")
            .redirectErrorStream(true)
            .start()
            .inputStream
            .bufferedReader()
            .readText()

        val connectedDevices = adbOutput.lines().filter { line ->
            line.isNotBlank() &&
                    !line.startsWith("List") &&
                    line.contains("device") &&
                    !line.startsWith("emulator-")
        }

        if (connectedDevices.none { it.startsWith(targetDevice) }) {
            throw GradleException("ERROR: Required physical device ($targetDevice) is not connected.")
        } else {
            println("✅ Physical device ($targetDevice) is connected. Proceeding with build.")
        }
    }
}