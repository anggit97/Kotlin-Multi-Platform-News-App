import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("kotlinx-serialization")
}

kotlin {
    //select iOS target platform depending on the Xcode environment variables
    val iOSTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
            ::iosArm64
        else
            ::iosX64

    iOSTarget("ios") {
        binaries {
            framework {
                baseName = "Shared"
            }
        }
    }

    jvm("android")

    sourceSets["commonMain"].dependencies {
        api("org.jetbrains.kotlin:kotlin-stdlib")

        val kotlinVersion = "1.3.61"
        implementation("org.jetbrains.kotlin:kotlin-stdlib-common:$kotlinVersion")

        // COROUTINE
        val coroutineVersion = "1.2.1"
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:$coroutineVersion")

        // SERIALIZATION
        val serializerVersion = "0.13.0"
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:$serializerVersion")

        // KTOR
        val ktorVersion = "1.2.5"
        implementation("io.ktor:ktor-client-core:$ktorVersion")
    }

    sourceSets["androidMain"].dependencies {
        api("org.jetbrains.kotlin:kotlin-stdlib")

        val kotlinVersion = "1.3.61"
        implementation("org.jetbrains.kotlin:kotlin-stdlib-common:$kotlinVersion")

        // COROUTINE
        val coroutineVersion = "1.2.1"
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion")

        // SERIALIZATION
        val serializerVersion = "0.13.0"
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializerVersion")

        // KTOR
        val ktorVersion = "1.2.5"
        implementation("io.ktor:ktor-client-android:$ktorVersion")
    }

    sourceSets["iosMain"].dependencies {
        val kotlinVersion = "1.3.61"
        implementation("org.jetbrains.kotlin:kotlin-stdlib-common:$kotlinVersion")

        // COROUTINE
        val coroutineVersion = "1.2.1"
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:$coroutineVersion")

        // SERIALIZATION
        val serializerVersion = "0.13.0"
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-native:$serializerVersion")

        // KTOR
        val ktorVersion = "1.2.5"
        implementation("io.ktor:ktor-client-ios:$ktorVersion")
    }
}

val packForXcode by tasks.creating(Sync::class) {
    val targetDir = File(buildDir, "xcode-frameworks")

    /// selecting the right configuration for the iOS 
    /// framework depending on the environment
    /// variables set by Xcode build
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val framework = kotlin.targets
        .getByName<KotlinNativeTarget>("ios")
        .binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)

    from({ framework.outputDirectory })
    into(targetDir)

    /// generate a helpful ./gradlew wrapper with embedded Java path
    doLast {
        val gradlew = File(targetDir, "gradlew")
        gradlew.writeText(
            "#!/bin/bash\n"
                    + "export 'JAVA_HOME=${System.getProperty("java.home")}'\n"
                    + "cd '${rootProject.rootDir}'\n"
                    + "./gradlew \$@\n"
        )
        gradlew.setExecutable(true)
    }
}

tasks.getByName("build").dependsOn(packForXcode)