plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is used by the application.
    implementation(libs.guava)
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(18)
    }
}

application {
    // Define the main class for the application.
    mainClass = "dev.trelawnm.exercises.FindSubstring"
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        // specify manifest for run .jar file with `java -jar`
        attributes["Main-Class"] = application.mainClass.get()
    }
}

tasks.run {
    // define standart input for program
    standardInput = System.`in`
}